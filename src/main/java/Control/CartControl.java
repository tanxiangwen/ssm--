package Control;

import Pojo.Book;
import Pojo.Cart;
import Pojo.CartItem;
import Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CartControl {
    @Autowired
    CartService cartService;
    @RequestMapping("/additem")
    public ModelAndView addCart(int id, HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        //首先根据id查出book信息存储到商品项
        Book book = cartService.queryById(id);

        CartItem cartItem=new CartItem(book.getId(), book.getName(), 1, book.getPrice(),book.getPrice());
        Cart cart=(Cart) request.getSession().getAttribute("cart");
        if(cart==null){
           cart= new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        //添加
        cart.addItem(cartItem);
        request.setAttribute("bookName", cartItem.getName());
        modelAndView.setViewName("/client/index.jsp");
        return modelAndView;


    }
    @RequestMapping("/delete")
    public String delete(int id,HttpServletRequest request){
      Cart cart=(Cart)request.getSession().getAttribute("cart");
      if(cart!=null){
          cart.delete(id);
      }
      return "/pages/cart/cart.jsp";

    }
    @RequestMapping("/update")
    public void update(int id, int count, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView modelAndView=new ModelAndView();
        Cart cart=(Cart)request.getSession().getAttribute("cart");
        if(cart!=null){
            cart.update(id, count);
        }
        response.sendRedirect(request.getHeader("Referer"));




    }
    @RequestMapping("/clear")
    public String clear(HttpServletRequest request){
        Cart cart=(Cart)request.getSession().getAttribute("cart");
        if(cart!=null){
            cart.clear();
        }
        return "/pages/cart/cart.jsp";

    }
}
