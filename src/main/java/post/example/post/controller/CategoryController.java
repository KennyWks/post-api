package post.example.post.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import post.example.post.model.request.CategoryRequest;
import post.example.post.model.response.CategoryResponse;
import post.example.post.model.response.CategoryResponse;
import post.example.post.service.CategoryService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable long id){
        return new ResponseEntity(categoryService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest categoryRequest){
        return new ResponseEntity<>(categoryService.create(categoryRequest),HttpStatus.CREATED);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<CategoryResponse> delete(@PathVariable long id){
//        return new ResponseEntity<>(categoryService.delete(id),HttpStatus.OK);
//    }
}
