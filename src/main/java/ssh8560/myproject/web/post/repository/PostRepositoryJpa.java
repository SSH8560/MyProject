package ssh8560.myproject.web.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssh8560.myproject.web.domain.Post;


public interface PostRepositoryJpa extends JpaRepository<Post, Long> {
}
