package ru.stuff.coworking.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/home").setViewName("home");
//        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/sign_up").setViewName("user/sign_up");
        registry.addViewController("/login").setViewName("user/sign_in");
    }
}
