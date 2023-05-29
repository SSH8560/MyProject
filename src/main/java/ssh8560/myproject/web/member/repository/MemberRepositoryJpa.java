package ssh8560.myproject.web.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ssh8560.myproject.web.domain.Member;

import java.util.Optional;

public interface MemberRepositoryJpa extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
}
