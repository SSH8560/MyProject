package ssh8560.myproject.web.comment.repository;

import ssh8560.myproject.web.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {
    public Comment saveComment(Comment comment);

    Optional<Comment> findById(Long id);

    public List<Comment> findByPostId(Long postId);

    public void deleteById(Long id);

    public void deleteAll();
}
