package post.example.post.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import post.example.post.entity.Users;
import post.example.post.exception.CustomException;
import post.example.post.model.response.UserResponse;
import post.example.post.repository.UserRepository;
import post.example.post.service.UserService;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserResponse getById(long id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        "User with given id " + id + " Not Found",
                        "USER_NOT_FOUND", 404));
        return mappingUserToUserResponse(user);
    }

    public UserResponse mappingUserToUserResponse(Users users) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(users, userResponse);
        return userResponse;
    }
}
