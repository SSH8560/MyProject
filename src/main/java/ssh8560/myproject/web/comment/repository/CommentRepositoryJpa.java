package ssh8560.myproject.web.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssh8560.myproject.web.domain.Comment;

import java.util.List;

public interface CommentRepositoryJpa extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long id);
}
