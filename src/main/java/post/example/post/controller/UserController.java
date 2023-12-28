package post.example.post.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
