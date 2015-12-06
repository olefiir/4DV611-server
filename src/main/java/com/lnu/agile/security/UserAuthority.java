package com.lnu.agile.security;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@IdClass(UserAuthority.class)
public class UserAuthority implements GrantedAuthority {

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @Id
    private AuthUser user;

    @Id
    private String authority;

    public AuthUser getUser() {
        return user;
    }

    public void setUser(AuthUser user) {
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof UserAuthority)) {
            return false;
        }

        UserAuthority ua = (UserAuthority) obj;
        return ua.getAuthority() == this.getAuthority() || ua.getAuthority().equals(this.getAuthority());
    }

    @Override
    public int hashCode() {
        return getAuthority() == null ? 0 : getAuthority().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + getAuthority();
    }
}
