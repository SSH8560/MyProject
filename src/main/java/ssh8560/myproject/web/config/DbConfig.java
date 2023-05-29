package ssh8560.myproject.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ssh8560.myproject.web.member.repository.MemberRepository;
import ssh8560.myproject.web.post.repository.PostRepository;
import ssh8560.myproject.web.post.repository.PostRepositoryJpa;
import ssh8560.myproject.web.post.repository.PostRepositoryImpl;
import ssh8560.myproject.web.comment.repository.CommentRepositoryJpa;
import ssh8560.myproject.web.comment.repository.CommentRepository;
import ssh8560.myproject.web.comment.repository.CommentRepositoryImpl;
import ssh8560.myproject.web.member.repository.MemberRepositoryImpl;
import ssh8560.myproject.web.member.repository.MemberRepositoryJpa;

import javax.persistence.EntityManager;

@Configuration
public class DbConfig {

    private final EntityManager entityManager;

    private final MemberRepositoryJpa memberRepositoryJpa;
    private final CommentRepositoryJpa commentRepositoryJpa;
    private final PostRepositoryJpa postRepositoryJpa;

    public DbConfig(EntityManager entityManager,
                    MemberRepositoryJpa memberRepositoryJpa,
                    PostRepositoryJpa postRepositoryJpa,
                    CommentRepositoryJpa commentRepositoryJpa) {
        this.entityManager = entityManager;
        this.memberRepositoryJpa = memberRepositoryJpa;
        this.postRepositoryJpa = postRepositoryJpa;
        this.commentRepositoryJpa = commentRepositoryJpa;
    }

    @Bean
    public MemberRepository memberRepository(MemberRepositoryJpa memberRepositoryJpa) {
        return new MemberRepositoryImpl(memberRepositoryJpa);
    }

    @Bean
    public PostRepository postRepository() {
        return new PostRepositoryImpl(postRepositoryJpa, entityManager);
    }

    @Bean
    public CommentRepository commentRepository() {
        return new CommentRepositoryImpl(commentRepositoryJpa);
    }
}
