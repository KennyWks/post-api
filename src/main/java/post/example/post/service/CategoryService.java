package post.example.post.service;

import post.example.post.model.request.CategoryRequest;
import post.example.post.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> getAll();
    CategoryResponse getById(long id);

    CategoryResponse create(CategoryRequest categoryRequest);

    CategoryResponse update(long id, CategoryRequest categoryRequest);

    CategoryResponse delete(long id);
}
