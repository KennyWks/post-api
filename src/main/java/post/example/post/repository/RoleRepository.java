package post.example.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import post.example.post.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
