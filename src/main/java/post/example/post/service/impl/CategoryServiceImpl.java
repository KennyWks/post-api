package post.example.post.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import post.example.post.entity.Category;
import post.example.post.exception.CustomException;
import post.example.post.model.request.CategoryRequest;
import post.example.post.model.response.CategoryResponse;
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
                        "Category with given id " + id + " Not Found",
                        "CATEGORY_NOT_FOUND", 404));
        return mappingCategoryToCategoryResponse(category);
    }

    @Override
    public CategoryResponse create(CategoryRequest categoryRequest) {
        if (categoryRepository.findByName(categoryRequest.getName()).isPresent()) {
            throw new CustomException("Category with name : " + categoryRequest.getName() + " is already exists",
                    "CATEGORY_NAME_EXISTS", 400);
        }

//        Category category = new Category();
//        category.setName(categoryRequest.getName());
//        category.setSlug(categoryRequest.getSlug());
//        category.setCreated_at(categoryRequest.getCreated_at());
//        category.setUpdated_at(categoryRequest.getUpdated_at());
//        Category res = categoryRepository.save(category);

        Category category = categoryRepository.save(mappingCategoryRequestToCategory(categoryRequest, new Category()));
        return mappingCategoryToCategoryResponse(category);
    }

    @Override
    public CategoryResponse update(long id, CategoryRequest categoryRequest) {
        CategoryResponse oldData = getById(id);

        Category category = new Category();

        category.setId(oldData.getId());

        category.setName(oldData.getName());
        category.setName(categoryRequest.getName());

        category.setSlug(oldData.getSlug());
        category.setSlug(categoryRequest.getSlug());

        category.setCreated_at(oldData.getCreated_at());
        category.setCreated_at(categoryRequest.getCreated_at());

        category.setUpdated_at(oldData.getUpdated_at());
        category.setUpdated_at(categoryRequest.getUpdated_at());

        Category res = categoryRepository.save(category);
        return mappingCategoryToCategoryResponse(res);
    }

    @Override
    public CategoryResponse delete(long id) {
        CategoryResponse category = getById(id);
        categoryRepository.deleteById(id);
        return category;
    }

    public Category mappingCategoryRequestToCategory(CategoryRequest categoryRequest, Category category) {
        BeanUtils.copyProperties(categoryRequest, category);
        return category;
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
