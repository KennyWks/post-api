package post.example.post.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import post.example.post.entity.Category;
import post.example.post.entity.Post;
import post.example.post.exception.CustomException;
import post.example.post.model.request.CategoryRequest;
import post.example.post.model.request.PostRequest;
import post.example.post.model.response.CategoryResponse;
import post.example.post.model.response.PostResponse;
import post.example.post.repository.CategoryRepository;
import post.example.post.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> {
                    return mappingCategoryResponseToCategory(category);
                }).collect(Collectors.toList());
    }

    @Override
    public CategoryResponse getById(long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        "Country with given id " + id + " Not Found",
                        "COUNTRY_NOT_FOUND", 404));
        return mappingCategoryToCategoryResponse(category);
    }

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        category.setSlug(categoryRequest.getSlug());
        category.setCreated_at(categoryRequest.getCreated_at());
        category.setUpdated_at(categoryRequest.getUpdated_at());
        Category res = categoryRepository.save(category);
        return mappingCategoryToCategoryResponse(res);
    }

    public CategoryResponse mappingCategoryToCategoryResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        BeanUtils.copyProperties(category, categoryResponse);
        return categoryResponse;
    }

    public CategoryResponse mappingCategoryResponseToCategory(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        BeanUtils.copyProperties(category, categoryResponse);
        return categoryResponse;
    }
}
