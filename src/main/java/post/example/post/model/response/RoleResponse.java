package post.example.post.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponse {

    private long id;
    private String name;
    private String created_at;
    private String updated_at;
}
