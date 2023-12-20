package post.example.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import post.example.post.entity.Category;
import org.springframework.stereotype.Repository;
import post.example.post.entity.Post;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Post> findByName(String name);
}
