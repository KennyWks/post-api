package post.example.post.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String slug;

    @Column()
    private String image;

    @Column(nullable = false)
    private String excerpt;

    @Column(nullable = false)
    private String body;

    @Column()
    private String published_at;

    @Column()
    private String created_at;

    @Column()
    private String updated_at;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Category category;
}
