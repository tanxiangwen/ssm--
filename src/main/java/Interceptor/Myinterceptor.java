package Interceptor;

import Pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Myinterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取登录用户信息
        User user = (User) request.getSession().getAttribute("user");
        if(user==null){
            //重定向到登录界面
            response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
            return false;
        }
        return true;
    }
}
