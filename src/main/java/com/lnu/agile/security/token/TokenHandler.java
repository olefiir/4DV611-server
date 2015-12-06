package com.lnu.agile.security.token;

import com.lnu.agile.dao.UserService;
import com.lnu.agile.model.TpsUser;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 *
 * @author olefir
 */
public final class TokenHandler {

    private static final String SEPARATOR = "\\.";
    private static final String SECRET_KEY = "agilehorses";

    public TokenHandler() {
    }

    public TpsUser parseUserFromToken(String token) {
        try {
            String values = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
            String email = values.split(SEPARATOR)[0];
            String id = values.split(SEPARATOR)[1];

            return new UserService().findByEmailId(email, id);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException x) {
            return null;
        }
    }

    public String createTokenForUser(TpsUser user) {
        return Jwts.builder()
                .setSubject(user.getUserEmail() + SEPARATOR + user.getUserId())
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
