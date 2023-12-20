package post.example.post.service.impl;

import org.springframework.beans.BeanUtils;
import post.example.post.entity.Category;
import post.example.post.entity.Post;
import lombok.AllArgsConstructor;
import post.example.post.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import post.example.post.model.request.PostRequest;
import post.example.post.model.response.CategoryResponse;
import post.example.post.model.response.PostResponse;
import org.springframework.stereotype.Service;
import post.example.post.repository.CategoryRepository;
import post.example.post.repository.PostRepository;
import post.example.post.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private CategoryRepository categoryRepository;

    @Override
    public List<PostResponse> getAll() {
        return postRepository.findAll()
                .stream()
                .map(post -> {
                    return mappingPostToPostResponse(post);
                }).collect(Collectors.toList());
    }

    @Override
    public PostResponse getById(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new CustomException(
                        "Country with given id " + id + " Not Found",
                        "COUNTRY_NOT_FOUND", 404));
        return mappingPostToPostResponse(post);
    }

    @Override
    public PostResponse create(PostRequest postRequest) {
        if (postRepository.findByTitle(postRequest.getTitle()).isPresent()) {
            throw new CustomException("Post with title : " + postRequest.getTitle() + " is already exists",
                    "POST_TITLE_EXISTS", 400);
        }
        Post post = postRepository.save(mappingPostRequestToPost(postRequest, new Post()));
        return mappingPostToPostResponse(post);
    }

    @Override
    public PostResponse delete(long id) {
        PostResponse country = getById(id);
        postRepository.deleteById(id);
        return country;
    }

    public Post mappingPostRequestToPost(PostRequest postRequest, Post post) {
        BeanUtils.copyProperties(postRequest, post);

        Category category = categoryRepository.findById(postRequest.getCategory_id()).get();

        post.setCategory(category);
        return post;
    }

    public PostResponse mappingPostToPostResponse(Post post) {
        PostResponse postResponse = new PostResponse();
        BeanUtils.copyProperties(post, postResponse);

        if (post.getCategory() != null){
            CategoryResponse categoryResponse = new CategoryResponse();
            BeanUtils.copyProperties(post.getCategory(), categoryResponse);
            postResponse.setCategory(categoryResponse);
        }
        return postResponse;
    }

}