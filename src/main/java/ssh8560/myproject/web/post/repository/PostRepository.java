package ssh8560.myproject.web.post.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ssh8560.myproject.web.domain.Post;

import java.util.Optional;


public interface PostRepository {
    Post save(Post post);

    Optional<Post> findById(Long id);

    Page<Post> findAll(Pageable pageable);

    Page<Post> findByTargetAndQuery(Pageable pageable, String target, String query);

    public void update(Long id, Post post);

    public void deleteAll();

    public void deleteById(Long id);
}
