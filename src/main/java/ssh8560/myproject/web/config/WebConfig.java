package ssh8560.myproject.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ssh8560.myproject.web.config.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns(
                        "/css/**", "/js/**", "**.ico", "/error", "**.js",
                        "/","/login","/member/register", "/member/duplicate", "/error-page/**");
    }
}
