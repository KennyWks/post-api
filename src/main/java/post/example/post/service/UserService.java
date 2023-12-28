package post.example.post.service;

import post.example.post.model.response.UserResponse;

public interface UserService {

    UserResponse getById(long id);
}
