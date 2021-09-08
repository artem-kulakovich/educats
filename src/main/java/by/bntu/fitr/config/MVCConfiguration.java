package by.bntu.fitr.config;


import by.bntu.fitr.interceptor.CheckAuthenticationInterceptor;
import by.bntu.fitr.interceptor.CheckAdminRoleInterceptor;
import by.bntu.fitr.interceptor.CheckLogOutInterceptor;
import by.bntu.fitr.interceptor.CheckTeacherRoleInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan(basePackages = "by.bntu.fitr")
@EnableWebMvc
public class MVCConfiguration implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setSuffix(".jsp");
        internalResourceViewResolver.setPrefix("/WEB-INF/view/page/");
        return internalResourceViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/media/**").addResourceLocations("/media/");
        registry.addResourceHandler("/favicon.ico").addResourceLocations("/favicon.ico");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CheckAuthenticationInterceptor()).addPathPatterns("/main", "/admin/**","/teacher/**").order(1);
        registry.addInterceptor(new CheckAdminRoleInterceptor()).addPathPatterns("/admin/**").order(2);
        registry.addInterceptor(new CheckTeacherRoleInterceptor()).addPathPatterns("/teacher/**").order(2);
        registry.addInterceptor(new CheckLogOutInterceptor()).addPathPatterns("/sign-in","/sign-up").order(1);
    }
}
