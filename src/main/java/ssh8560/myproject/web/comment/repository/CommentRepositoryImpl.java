package ssh8560.myproject.web.comment.repository;

import lombok.RequiredArgsConstructor;
import ssh8560.myproject.web.domain.Comment;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {
    private final CommentRepositoryJpa commentRepositoryJpa;

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepositoryJpa.save(comment);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepositoryJpa.findById(id);
    }

    @Override
    public List<Comment> findByPostId(Long postId) {
        return commentRepositoryJpa.findByPostId(postId);
    }

    @Override
    public void deleteById(Long id) {
        commentRepositoryJpa.deleteById(id);
    }

    @Override
    public void deleteAll() {
        commentRepositoryJpa.deleteAll();
    }
}
