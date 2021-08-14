package Control;

import Pojo.Cart;
import Pojo.User;
import Service.OrderPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class OrderControl {
    @Autowired
    OrderPayService orderPayService;
    @RequestMapping("/order")
    public void order(HttpServletResponse resp, HttpServletRequest req) throws ServletException, IOException {
        //先获取购物车对象
        Cart cart= (Cart)req.getSession().getAttribute("cart");
        //获取user信息进而获取userid
        User user= (User)req.getSession().getAttribute("user");
        if(user==null){
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);

        }
        //获取用户id
        Integer loginid=user.getId();

        String creatorder =orderPayService.creatorder(cart,loginid);


        req.getSession().setAttribute("creadeorder",creatorder);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");

    }
}
