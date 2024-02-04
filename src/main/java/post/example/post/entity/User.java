package post.example.post.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    private long id;
    private String username;
    private String password;
    private String email;
    private boolean isAccountLocked = false;
    private boolean isEnabled = true;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private UserDetails userDetails;

    // LAZY
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
