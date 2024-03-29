package post.example.post.model;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import post.example.post.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Slf4j
public class AppUserDetail implements org.springframework.security.core.userdetails.UserDetails {
    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles()
                .forEach(roles -> {
                            String role = "ROLE_"+ roles.getName().toUpperCase();
                            authorities.add(new SimpleGrantedAuthority(role));
                            roles.getPrivileges().forEach(privileges -> {
                                String privilege = privileges.getName().toUpperCase();
                                authorities.add(new SimpleGrantedAuthority(privilege));
                            });
                        }
                );
        log.info("Authorisation : {}",authorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}
