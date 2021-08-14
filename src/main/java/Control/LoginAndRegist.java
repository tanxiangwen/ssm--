package Control;

import Pojo.User;
import Service.UserLoginAndRegistServiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@Controller
public class LoginAndRegist {
    @Autowired
    private UserLoginAndRegistServiel userLoginAndRegistServiel;
    @RequestMapping("/login")
    public ModelAndView login(String username, String password, HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        //判断用户名密码是否正确
        User user = userLoginAndRegistServiel.logins(username, password);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            //正确，跳转到首页
            modelAndView.setViewName("/pages/user/login_success.jsp");
        }else{
            request.setAttribute("error", username);
            //重新到登录界面，数据回显
            modelAndView.setViewName("/pages/user/login.jsp");

        }
        return modelAndView;

    }
    @RequestMapping("/regist")
    public ModelAndView regist(User user,String code,HttpServletRequest request ){
        ModelAndView modelAndView=new ModelAndView();
        //首先判断验证码是否正确
        String token=(String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //销毁
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        if(token!=null&&token.equalsIgnoreCase(code)){
            //验证码正确，继续判断用户名是否已经存在
            User user1 = userLoginAndRegistServiel.lookUser(user.getUsername());
            if(user1!=null){
                //说明用户名已经存在,错误信息回显
                request.setAttribute("error","用户名已经存在");
                request.setAttribute("email",user.getEmail());
                modelAndView.setViewName("/pages/user/regist.jsp");

            }else{
                //说明用户名可用保存数据
                 userLoginAndRegistServiel.regist(user);
                //保存用户名到session
                request.getSession().setAttribute("user",user);
                //保存user到session

                request.getSession().setAttribute("username",user.getUsername() );

                //跳转界面
                modelAndView.setViewName("/pages/user/regist_success.jsp");
            }

        }else{
            //说明验证码不正确
            request.setAttribute("error", "验证码不正确");
            request.setAttribute("username",user.getUsername());
            request.setAttribute("email", user.getEmail());
            modelAndView.setViewName("/pages/user/regist.jsp");

        }
        return modelAndView;


    }
    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        request.getSession().invalidate();
        return "/pages/user/login.jsp";

    }
}
