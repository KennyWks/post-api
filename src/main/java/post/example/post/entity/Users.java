package post.example.post.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column()
    private String email_verified_at;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int role_id;

    @Column(nullable = false)
    private String remember_token;

    @Column(nullable = false)
    private String created_at;

    @Column(nullable = false)
    private String updated_at;

    @OneToMany(mappedBy = "user")
    private List<Post> post;
}
