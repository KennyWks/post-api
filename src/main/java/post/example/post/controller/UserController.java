package post.example.post.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import post.example.post.model.request.UserRequest;
import post.example.post.model.response.UserResponse;
import post.example.post.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable long id){
        return new ResponseEntity(userService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<UserResponse> update(@PathVariable long id, @RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userService.update(id,userRequest),HttpStatus.OK);
    }
}
