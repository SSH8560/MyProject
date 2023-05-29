package ssh8560.myproject.web.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssh8560.myproject.web.comment.repository.CommentRepository;
import ssh8560.myproject.web.domain.Member;
import ssh8560.myproject.web.domain.Post;
import ssh8560.myproject.web.domain.Comment;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public void commentOnBoard(Member member, String commentContent, Long boardId) {
        Comment comment = new Comment();
        comment.setContent(commentContent);
        comment.setMember(member);

        Post post = new Post();
        post.setId(boardId);
        comment.setPost(post);
        commentRepository.saveComment(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public List<Comment> getComments(Long boardId) {
        List<Comment> comments = commentRepository.findByPostId(boardId);
        return comments;
    }

    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }
}
