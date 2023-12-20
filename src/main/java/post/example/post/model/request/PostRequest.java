package post.example.post.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {

    private long category_id;
    private long user_id;
    private String title;
    private String slug;
    private String image;
    private String excerpt;
    private String body;
    private String published_at;
    private String created_at;
    private String updated_at;
}
