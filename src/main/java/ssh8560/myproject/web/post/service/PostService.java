package ssh8560.myproject.web.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ssh8560.myproject.web.domain.Member;
import ssh8560.myproject.web.member.repository.MemberRepository;
import ssh8560.myproject.web.domain.Post;
import ssh8560.myproject.web.post.repository.PostRepository;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PostService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public void writeBoard(Member member, Post post) {
        post.setMember(member);
        postRepository.save(post);
    }

    public Page<Post> simpleSearchBoards(Pageable pageable, String target, String query) {
        return postRepository.findByTargetAndQuery(pageable, target, query);
    }

    public Post getPost(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public Page<Post> getPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    public void removePost(Long id) {
        postRepository.deleteById(id);
    }

    public void editPost(Long id, String title, String content) {
        Post post = new Post();
        post.setContent(content);
        post.setTitle(title);
        post.setUpdatedDate(LocalDateTime.now());
        postRepository.update(id, post);
    }
}
