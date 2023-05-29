package ssh8560.myproject.web.login;


import lombok.Data;
import ssh8560.myproject.web.domain.Member;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {

    @NotEmpty(message = "아이디를 입력해주세요.")
    private String username;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;

    public Member toMember() {
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(password);
        return member;
    }
}
