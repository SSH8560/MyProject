package ssh8560.myproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import ssh8560.myproject.web.domain.Member;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(@SessionAttribute(value = SessionConst.LOGIN_MEMBER, required = false) Member member, Model model) {

        if (member != null) {
            model.addAttribute("member", member);
        }
        return "home";
    }
}
