package post.example.post.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column()
    private String created_at;

    @Column()
    private String updated_at;

//    @OneToMany(mappedBy = "role")
//    private List<UserDetails> users;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @ManyToMany(fetch = javax.persistence.FetchType.EAGER)
    @JoinTable(name = "tb_role_privilege",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private List<Privileges> privileges;
}
