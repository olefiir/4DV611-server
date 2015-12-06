package com.lnu.agile.security;

import com.lnu.agile.dao.UserService;
import com.lnu.agile.model.TpsUser;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {

    //private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    public final TpsUser loadUserByUsername(String email, String password) throws UsernameNotFoundException {

        TpsUser user = new UserService().findByEmailPassword(email, password);
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        //detailsChecker.check(user);
        return user;
    }
}
