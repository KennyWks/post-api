package post.example.post.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

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

    @Column()
    private String remember_token;

    @Column()
    private String created_at;

    @Column()
    private String updated_at;

    @ManyToOne
    private Role role;
}
