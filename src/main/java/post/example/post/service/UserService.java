package post.example.post.service;

import post.example.post.model.request.UserRequest;
import post.example.post.model.response.UserResponse;

public interface UserService {

    UserResponse getById(long id);

    UserResponse update(long id, UserRequest usertRequest);
}
