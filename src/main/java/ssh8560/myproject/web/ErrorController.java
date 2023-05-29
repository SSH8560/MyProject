package ssh8560.myproject.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class ErrorController {
    @RequestMapping("/error-page/404")
    public String errorPage404() {
        return "error-page/404";
    }

    @RequestMapping("/error-page/500")
    public String errorPage500() {
        return "error-page/500";
    }

    @RequestMapping("/error-page/access-denied")
    public String errorPageAccessDenied() {
        return "error-page/access-denied";
    }
}
