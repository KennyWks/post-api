package post.example.post.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import post.example.post.entity.User;
import post.example.post.exception.CustomException;
import post.example.post.model.AppUserDetail;
import post.example.post.repository.UserRepository;

@Service
@AllArgsConstructor
public class AppUserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(username, username)
                .orElseThrow(() -> new CustomException(
                        "Username or Password incorrect",
                        "INVALID_USERNAME_PASSWORD",
                        400));
        return new AppUserDetail(user);
    }
}
