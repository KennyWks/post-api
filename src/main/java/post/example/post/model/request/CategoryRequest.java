package post.example.post.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {

    private String name;
    private String slug;
    private String created_at;
    private String updated_at;
}
