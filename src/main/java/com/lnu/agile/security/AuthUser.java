/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.security;

import com.lnu.agile.model.TpsUser;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author olefir
 */
public class AuthUser {

    private TpsUser user;

    public AuthUser(TpsUser user) {
        this.user = user;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<UserAuthority> authorities;

    public void setRoles(Set<UserRole> roles) {
        for (UserRole role : roles) {
            grantRole(role);
        }
    }

    public void grantRole(UserRole role) {
        if (authorities == null) {
            authorities = new HashSet<>();
        }
        authorities.add(role.asAuthorityFor(this));
    }

    public Set<UserAuthority> getAuthorities() {
        if (authorities == null) {
            authorities = new HashSet<>();
        }
        authorities.add(UserRole.USER.asAuthorityFor(this));
        return authorities;
    }

    public boolean hasRole(UserRole role) {
        return authorities.contains(role.asAuthorityFor(this));
    }

    public Set<UserRole> getRoles() {
        Set<UserRole> roles = EnumSet.noneOf(UserRole.class);
        if (authorities != null) {
            for (UserAuthority authority : authorities) {
                roles.add(UserRole.valueOf(authority));
            }
        }
        return roles;
    }

    public String getUserEmail() {
        return user.getUserEmail();
    }

    public String getUserPassword() {
        return user.getUserPassword();
    }

    public String getUserAccountname() {
        return user.getUserAccountname();
    }
}
