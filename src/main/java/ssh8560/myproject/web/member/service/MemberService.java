package ssh8560.myproject.web.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssh8560.myproject.web.domain.Member;
import ssh8560.myproject.web.member.repository.MemberRepository;


@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Member createMember(Member member) {
        return memberRepository.saveMember(member);
    }

    public boolean isUsernameDuplicated(String accountId) {
        return memberRepository.getMemberByUsername(accountId).isPresent();
    }

}
