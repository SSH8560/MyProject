package ssh8560.myproject.web.member.controller;

import lombok.Getter;
import lombok.Setter;
import ssh8560.myproject.web.domain.Member;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Setter
@Getter
public class NewMemberForm {

    @Pattern(regexp = "^(?=[가-힣]*)(?=[a-zA-Z]*)([가-힣a-zA-Z]{1,20})$")
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^([a-zA-Z0-9]{1,20})$")
    private String username;

    @Pattern(regexp = "^(?=.*[\\w])(?=.*[!@#$%^&*])([\\w!@#$%^&*]{8,16})$")
    private String password;

    @Pattern(regexp = "^(?=[가-힣]*)(?=[a-zA-Z]*)([가-힣a-zA-Z]{1,20})$")
    private String nickname;

    public Member toMember() {
        Member member = new Member();
        member.setName(name);
        member.setEmail(email);
        member.setUsername(username);
        member.setPassword(password);
        member.setNickname(nickname);
        return member;
    }
}
