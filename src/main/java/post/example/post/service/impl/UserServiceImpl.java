package post.example.post.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import post.example.post.entity.User;
import post.example.post.exception.CustomException;
import post.example.post.model.request.UserRequest;
import post.example.post.model.response.RoleResponse;
import post.example.post.model.response.UserResponse;
import post.example.post.repository.UserRepository;
import post.example.post.service.UserService;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse getById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        "User with given id " + id + " Not Found",
                        "USER_NOT_FOUND", 404));
        return mappingUserToUserResponse(user);
    }

//    @Override
//    public UserResponse update(long id, UserRequest userRequest) {
//        UserResponse oldData = getById(id);
//
//        UserDetails user = new UserDetails();
//
//        user.setId(oldData.getId());
//
//        user.setName(oldData.getName());
//        user.setName(userRequest.getName());
//
//        user.setUsername(oldData.getUsername());
//        user.setUsername(userRequest.getUsername());
//
//        user.setEmail(oldData.getEmail());
//        user.setEmail(userRequest.getEmail());
//
//        user.setEmail_verified_at(oldData.getEmail_verified_at());
//        user.setEmail_verified_at(userRequest.getEmail_verified_at());
//
////      PasswordEncoder
//        user.setPassword(oldData.getPassword());
////        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
//        user.setPassword(userRequest.getPassword());
//
////        user.setRole_id(oldData.getRole_id());
////        user.setRole_id(userRequest.getRole_id());
//
//        UserDetails res = userRepository.save(user);
//        return mappingUserToUserResponse(res);
//    }

    public UserResponse mappingUserToUserResponse(User users) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(users, userResponse);

//        if (users.getRole() != null){
//            RoleResponse roleResponse = new RoleResponse();
//            BeanUtils.copyProperties(users.getRole(), roleResponse);
//            userResponse.setRole(roleResponse);
//        }
        return userResponse;
    }
}
