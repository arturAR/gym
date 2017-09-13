package com.java.academy.dao;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryUserDetailsDao implements UserDetailsDao {
    List<DefaultUserDetails> userDetails;

    public InMemoryUserDetailsDao() {
        userDetails = new ArrayList<>();
        userDetails.add(new DefaultUserDetails("user", "pass", false));
        userDetails.add(new DefaultUserDetails("admin", "admin", true));
    }

    @Override
    public UserDetails getDetailsByName(String name) {
        Optional<DefaultUserDetails> optional = userDetails.stream().filter(defaultUserDetails -> defaultUserDetails.getUsername().equals(name)).findFirst();
        return optional.orElse(null);
    }

    class DefaultUserDetails implements UserDetails {
        String password;
        String username;
        List<GrantedAuthority> authorities;

        DefaultUserDetails(String username, String password, boolean isAdmin) {
            Md5PasswordEncoder encoder = new Md5PasswordEncoder();
            this.password = encoder.encodePassword(password, "");
            this.username = username;
            this.authorities = new ArrayList<>();
            authorities.add(Authority.USER.getRole());
            if (isAdmin) {
                authorities.add(Authority.ADMIN.getRole());
            }
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

    enum Authority {
        USER {
            @Override
            public GrantedAuthority getRole() {
                return (GrantedAuthority) () -> "ROLE_USER";
            }
        },
        ADMIN {
            @Override
            public GrantedAuthority getRole() {
                return (GrantedAuthority) () -> "ROLE_ADMIN";
            }
        };

        public abstract GrantedAuthority getRole();
    }
}
