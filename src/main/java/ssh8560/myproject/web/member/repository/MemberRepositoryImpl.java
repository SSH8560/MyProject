package ssh8560.myproject.web.member.repository;

import lombok.RequiredArgsConstructor;
import ssh8560.myproject.web.domain.Member;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;


@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{

    private final MemberRepositoryJpa memberRepositoryJpa;

    @Override
    public Member saveMember(Member member) {
        return memberRepositoryJpa.save(member);
    }

    @Override
    public Optional<Member> getMemberByUsername(String username) {
        return memberRepositoryJpa.findByUsername(username);
    }

    @Override
    public void deleteAll() {
        memberRepositoryJpa.deleteAll();
    }
}
