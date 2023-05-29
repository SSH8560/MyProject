package ssh8560.myproject.web.post.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ssh8560.myproject.web.domain.Post;


import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static ssh8560.myproject.web.domain.QPost.*;

@Repository
@Transactional
@Slf4j
public class PostRepositoryImpl implements PostRepository {

    private final PostRepositoryJpa postRepositoryJpa;
    private final EntityManager entityManager;
    private final JPAQueryFactory queryFactory;

    public PostRepositoryImpl(PostRepositoryJpa postRepositoryJpa, EntityManager entityManager) {
        this.postRepositoryJpa = postRepositoryJpa;
        this.entityManager = entityManager;
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Post save(Post post) {
        return postRepositoryJpa.save(post);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepositoryJpa.findById(id);
    }


    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepositoryJpa.findAll(pageable);
    }

    public Page<Post> findByTargetAndQuery(Pageable pageable, String target, String query) {

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        switch (target) {
            case "title":
                booleanBuilder.and(post.title.likeIgnoreCase("%" + query + "%"));
                break;
            case "nickname":
                booleanBuilder.and(post.member.nickname.likeIgnoreCase("%" + query + "%"));
                break;
        }

        List<Post> fetch = queryFactory.selectFrom(post)
                .where(booleanBuilder)
                .orderBy(post.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize()).fetch();

        int count = queryFactory.selectFrom(post)
                .where(booleanBuilder)
                .fetch().size();

        return new PageImpl<>(fetch, pageable, count);
    }

    @Override
    public void update(Long id, Post post) {
        Post foundPost = postRepositoryJpa.findById(id).orElseThrow();
        foundPost.setTitle(post.getTitle());
        foundPost.setContent(post.getContent());
        foundPost.setUpdatedDate(LocalDateTime.now());
    }

    @Override
    public void deleteAll() {
        postRepositoryJpa.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        postRepositoryJpa.deleteById(id);
    }
}
