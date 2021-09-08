package by.bntu.fitr.interceptor;

import by.bntu.fitr.constant.Constant;
import by.bntu.fitr.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckAdminRoleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User user = (User) request.getSession().getAttribute("user");

        if (!user.getRole().getName().equals(Constant.ROLE_ADMIN)) {
            response.sendRedirect("/main");
            return false;
        }

        return true;
    }
}
