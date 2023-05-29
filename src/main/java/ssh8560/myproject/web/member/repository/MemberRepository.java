package ssh8560.myproject.web.member.repository;

import ssh8560.myproject.web.domain.Member;

import java.util.Optional;

public interface MemberRepository {
    public Member saveMember(Member member);

    public Optional<Member> getMemberByUsername(String username);

    public void deleteAll();
}
