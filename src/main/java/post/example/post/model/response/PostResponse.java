package post.example.post.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    private long id;
    private long user_id;
    private CategoryResponse category;
    private String title;
    private String slug;
    private String image;
    private String excerpt;
    private String body;
    private String published_at;
    private String created_at;
    private String updated_at;
}
