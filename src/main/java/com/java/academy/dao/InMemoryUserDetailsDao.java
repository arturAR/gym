package com.java.academy.dao;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class InMemoryUserDetailsDao implements UserDetailsDao {
    private List<DefaultUserDetails> userDetails;

    public InMemoryUserDetailsDao() {
        userDetails = new ArrayList<>();
        userDetails.add(new DefaultUserDetails("user", "pass", false));
        userDetails.add(new DefaultUserDetails("admin", "admin", true));
    }

    @Override
    public UserDetails getDetailsByName(String name) {
        System.out.println("Checking for " +name);
        return userDetails.stream().filter(defaultUserDetails -> defaultUserDetails.getUsername().equals(name)).findFirst().get();
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
            if(isAdmin) {
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

        @Override
        public String toString() {
            return "DefaultUserDetails{" +
                    "password='" + password + '\'' +
                    ", username='" + username + '\'' +
                    ", authorities=" + authorities +
                    '}';
        }
    }

    enum Authority {
        USER (() -> "ROLE_USER"),
        ADMIN (() -> "ROLE_ADMIN");

        GrantedAuthority role;

        Authority(GrantedAuthority role) {
            this.role = role;
        }

        public GrantedAuthority getRole() {
            return role;
        }
    }
}
