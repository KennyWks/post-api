package post.example.post.service;

import post.example.post.model.request.PostRequest;
import post.example.post.model.response.PostResponse;

import java.util.List;

public interface PostService {

    List<PostResponse> getAll();
    PostResponse getById(long id);

    PostResponse create(PostRequest postRequest);
    //    CountryResponse create(CountryRequest countryRequest);
    //    CountryResponse update(long id, CountryRequest countryRequest);
    PostResponse delete(long id);
}
