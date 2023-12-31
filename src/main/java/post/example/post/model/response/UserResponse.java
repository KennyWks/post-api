package post.example.post.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private long id;
    private String name;
    private String username;
    private String email;
    private String email_verified_at;
    private String password;
    private RoleResponse role;
    private String remember_token;
    private String created_at;
    private String updated_at;
}
