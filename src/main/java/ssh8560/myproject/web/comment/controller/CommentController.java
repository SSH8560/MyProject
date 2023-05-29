package ssh8560.myproject.web.comment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ssh8560.myproject.web.SessionConst;
import ssh8560.myproject.web.comment.service.CommentService;
import ssh8560.myproject.web.domain.Comment;
import ssh8560.myproject.web.domain.Member;

import java.security.AccessControlException;

@RequiredArgsConstructor
@RequestMapping("/comment")
@Controller
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{postId}")
    public String comment(@SessionAttribute(value = SessionConst.LOGIN_MEMBER, required = false) Member member,
                          @PathVariable("postId") Long postId,
                          @RequestParam("comment") String comment) {

        commentService.commentOnBoard(member, comment, postId);

        return "redirect:/post/{postId}";
    }

    @PostMapping("/delete/{commentId}")
    public String deleteComment(@SessionAttribute(value = SessionConst.LOGIN_MEMBER, required = false) Member member,
                                @PathVariable Long commentId,
                                @RequestParam("post") Long postId){
        if (canEditComment(member, commentId)) {
            commentService.deleteComment(commentId);
        }
        return "redirect:/post/"+postId;
    }

    private boolean canEditComment(Member member, Long commentId) {
        if (!commentService.getComment(commentId).getMember().equals(member)) {
            throw new AccessControlException("댓글을 수정할 권한이 없습니다.");
        }
        return true;
    }
}
