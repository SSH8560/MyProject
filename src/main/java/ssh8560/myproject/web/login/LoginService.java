package ssh8560.myproject.web.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ssh8560.myproject.web.domain.Member;
import ssh8560.myproject.web.member.repository.MemberRepository;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(Member member) {
        return memberRepository.getMemberByUsername(member.getUsername())
                .filter(m -> m.getPassword().equals(member.getPassword()))
                .orElse(null);
    }
}
