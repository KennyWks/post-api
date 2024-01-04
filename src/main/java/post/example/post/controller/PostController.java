package post.example.post.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import post.example.post.model.request.PostRequest;
import post.example.post.model.response.PostResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import post.example.post.service.PostService;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {

    private PostService postService;

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAll(){
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getById(@PathVariable long id){
        return new ResponseEntity(postService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostResponse> create(@RequestBody PostRequest postRequest){
        return new ResponseEntity<>(postService.create(postRequest),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> update(@PathVariable long id, @RequestBody PostRequest postRequest){
        return new ResponseEntity<>(postService.update(id,postRequest),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostResponse> delete(@PathVariable long id){
        return new ResponseEntity<>(postService.delete(id),HttpStatus.OK);
    }
}
