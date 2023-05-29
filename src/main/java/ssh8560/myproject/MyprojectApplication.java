package ssh8560.myproject;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import ssh8560.myproject.web.domain.Member;
import ssh8560.myproject.web.domain.Post;
import ssh8560.myproject.web.member.repository.MemberRepository;
import ssh8560.myproject.web.post.repository.PostRepository;
import ssh8560.myproject.web.comment.repository.CommentRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class MyprojectApplication {

	private final MemberRepository memberRepository;
	private final PostRepository postRepository;

	private final CommentRepository commentRepository;
	public static void main(String[] args) {
		SpringApplication.run(MyprojectApplication.class, args);
	}

	@PostConstruct
	public void init() {
		commentRepository.deleteAll();
		postRepository.deleteAll();
		memberRepository.deleteAll();


		Member member = new Member();
		member.setNickname("닉네임");
		member.setUsername("test");
		member.setPassword("1234");
		member.setEmail("test@test.com");
		member.setName("이름");
		memberRepository.saveMember(member);


		for (int i = 0; i < 20; i++) {
			Post post = new Post();
			post.setTitle("DUMMY "+ i);
			post.setContent("Testing");
			post.setMember(member);
			postRepository.save(post);
		}

	}
}
