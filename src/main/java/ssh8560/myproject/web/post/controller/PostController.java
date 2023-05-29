package ssh8560.myproject.web.post.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ssh8560.myproject.web.SessionConst;
import ssh8560.myproject.web.comment.service.CommentService;
import ssh8560.myproject.web.domain.Member;
import ssh8560.myproject.web.domain.Post;
import ssh8560.myproject.web.post.service.PostService;
import javax.servlet.http.HttpServletRequest;
import java.security.AccessControlException;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/post")
@Controller
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @GetMapping("/{id}")
    public String post(@PathVariable("id") Long id, Model model) {
        model.addAttribute("post", postService.getPost(id));
        model.addAttribute("comments", commentService.getComments(id));

        return "post/post";
    }

    @GetMapping("/list")
    public String postList(Model model,
                            HttpServletRequest httpServletRequest,
                            @RequestParam(value = "target",defaultValue = "") String target,
                            @RequestParam(value = "query", defaultValue = "") String query,
                            @RequestParam(value = "page", defaultValue = "1") int page) {

        PageRequest pageRequest = PageRequest.of(page - 1, 10, Sort.by("id").descending());

        if (StringUtils.hasText(target)) {
            model.addAttribute("pages", postService.simpleSearchBoards(pageRequest, target, query));
            model.addAttribute("target", target);
            model.addAttribute("query", query);
        } else {
            model.addAttribute("pages", postService.getPosts(pageRequest));
        }

        return "post/list-post";
    }


    @GetMapping("/write")
    public String writeForm(Model model) {
        model.addAttribute("post", new Post());
        return "post/write-post";
    }

    @PostMapping("/write")
    public String write(@SessionAttribute(value = SessionConst.LOGIN_MEMBER) Member member,
                        @Validated Post post,
                        BindingResult bindingResult,
                        Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("post", post);
            return "post/write-post";
        }

        postService.writeBoard(member, post);

        return "redirect:/post/list";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id,
                         Model model) {

        Post post = postService.getPost(id);
        model.addAttribute("post", post);

        return "post/edit-post";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id,
                         @SessionAttribute(value = SessionConst.LOGIN_MEMBER) Member member,
                         @Validated Post post,
                         BindingResult bindingResult,
                         Model model) {

        if (!canEditPost(member, id)) {
            throw new AccessControlException("게시글을 수정할 권한이 없습니다.");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("post", post);
            return "post/edit-post";
        }

        postService.editPost(id, post.getTitle(), post.getContent());
        return "redirect:/post/{id}";
    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,
                         @SessionAttribute(value = SessionConst.LOGIN_MEMBER) Member member) {

        if (!canEditPost(member, id)) {
            throw new AccessControlException("게시글을 수정할 권한이 없습니다.");
        }

        postService.removePost(id);
        return "redirect:/post/list";
    }

    private boolean canEditPost(Member member, Long postId) {
        Post post = postService.getPost(postId);
        if (post.getMember().equals(member)) {
            return true;
        }
        return false;
    }
}
