package ssh8560.myproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ssh8560.myproject.web.comment.repository.CommentRepository;

@SpringBootTest
class MyprojectApplicationTests {

	@Autowired
	private CommentRepository commentRepository;

	@Test
	void contextLoads() {
	}

}
