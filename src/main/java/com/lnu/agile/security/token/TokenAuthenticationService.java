package com.lnu.agile.security.token;

import com.lnu.agile.security.UserAuthentication;
import com.lnu.agile.model.TpsUser;
import com.lnu.agile.security.AuthUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 *
 * @author olefir
 */
@Service
public class TokenAuthenticationService {

    private static final String AUTH_HEADER_NAME = "X-AUTH-TOKEN";
    private static final long TEN_DAYS = 1000 * 60 * 60 * 24 * 10;

    private final TokenHandler tokenHandler;

    public TokenAuthenticationService() {
        tokenHandler = new TokenHandler();
    }

    public String addAuthentication(HttpServletResponse response, TpsUser user) {

        String token = tokenHandler.createTokenForUser(user);
        response.addHeader(AUTH_HEADER_NAME, token);

        return token;
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);
        if (token != null) {
            TpsUser user = tokenHandler.parseUserFromToken(token);
            if (user != null) {
                Authentication tempVar = new UserAuthentication(new AuthUser(user));
                return tempVar;
            }
        }
        return null;
    }
}
