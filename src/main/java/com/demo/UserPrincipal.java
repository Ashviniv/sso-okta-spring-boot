package com.demo;

import com.demo.models.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserPrincipal extends org.springframework.security.core.userdetails.User {

    private final com.demo.models.User user;

    public UserPrincipal(com.demo.models.User user, Collection<? extends GrantedAuthority> authorities) {
        super("Unknown user", "no password", authorities);
        this.user = user;
    }

    public UserPrincipal(com.demo.models.User user, boolean enabled, boolean accountNonExpired,
                         boolean credentialsNonExpired,
                         boolean accountNonLocked,
                         Collection<? extends GrantedAuthority> authorities) {
        super("Unknown Username", "no password",
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}