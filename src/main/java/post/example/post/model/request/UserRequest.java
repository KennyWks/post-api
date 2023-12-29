package post.example.post.model.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String name;
    private String username;
    private String email;
    private String email_verified_at;
    private String password;
    private long role_id;
    private String remember_token;
    private String created_at;
    private String updated_at;
}
