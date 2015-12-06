package com.lnu.agile.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class UserAuthentication implements Authentication {

    private final AuthUser user;
    private boolean authenticated = true;

    public UserAuthentication(AuthUser user) {
        this.user = user;
    }

    @Override
    public String getName() {
        return user.getUserEmail();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return user.getUserPassword();
    }

    @Override
    public AuthUser getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user.getUserAccountname();
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
