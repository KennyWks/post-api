package post.example.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import post.example.post.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
}
