package post.example.post.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import post.example.post.entity.Users;
import post.example.post.exception.CustomException;
import post.example.post.repository.UserRepository;

public class AppUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsernameOrEmail(username, username)
                .orElseThrow(() -> new CustomException(
                        "Username or Password incorrect",
                        "INVALID_USERNAME_PASSWORD",
                        400));
        return new AppUserDetail(user);
    }
}
