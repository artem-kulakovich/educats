package by.bntu.fitr.interceptor;


import by.bntu.fitr.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckAuthenticationInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            response.sendRedirect("/sign-in");
            return false;
        }

        return true; //запускает второй перехватчик
    }
}
