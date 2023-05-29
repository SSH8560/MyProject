package ssh8560.myproject.web.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ssh8560.myproject.web.member.service.MemberService;
import ssh8560.myproject.web.domain.Member;

import java.io.IOException;


@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/register")
    public String getNewMemberForm(Model model) {
        model.addAttribute(new NewMemberForm());
        return "member/register";
    }


    @PostMapping("/register")
    public String newMember(@Validated @ModelAttribute NewMemberForm newMemberForm,
                            BindingResult bindingResult,
                            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(newMemberForm);
            return "member/register";
        }

        memberService.createMember(newMemberForm.toMember());
        return "redirect:/";
    }

    @ResponseBody
    @PostMapping("/duplicate")
    public Boolean checkUsernameDuplication(@RequestBody String username) throws IOException {
        return memberService.isUsernameDuplicated(username);
    }
}


