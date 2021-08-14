package Control;

import Pojo.Book;
import Service.ClientBookPageServlet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import utils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class Client {
    @Autowired
    ClientBookPageServlet clientBookPageServlet;
    /**
     * 前台数据展示以及分页默认第一页
     * @param request
     * @return
     */
    @RequestMapping("/pagelist")
    public ModelAndView Page(int pageNo,HttpServletRequest request){
        String url="pagelist";
        ModelAndView modelAndView=new ModelAndView();
       //int pageNos= BeanUtils.parsint(pageNo, 1);
        PageHelper.startPage(pageNo,4);
        List<Book> list = clientBookPageServlet.list();
        request.setAttribute("url", url);
        for (Book book : list) {
            request.getSession().setAttribute("Book", list);

        }
        PageInfo<Book> pageInfo=new PageInfo<Book>(list);
       request.getSession().setAttribute("pageInfo", pageInfo);
       modelAndView.setViewName("/client/index.jsp");
       return modelAndView;



    }
    /**
     * 前台价格区间查询显示
     */
    @RequestMapping("/PageByprice")
    public void PageByprice(String min, String max, int pageNo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ModelAndView modelAndView=new ModelAndView();
        //获取价格区间
        int Min = BeanUtils.parsins(min, 0);
        int Max = BeanUtils.parsins(max, 10000);
        PageHelper.startPage(pageNo, 4);
        List<Book> books = clientBookPageServlet.byPrice(Min,Max);
        for (Book book : books) {
            request.getSession().setAttribute("Book",books);

        }
        StringBuilder builder=new StringBuilder("PageByprice?");
        if(request.getParameter("min")!=null){
            builder.append("min=").append(request.getParameter("min"));
        }
        if(request.getParameter("max")!=null){
            builder.append("&max=").append(request.getParameter("max"));
        }
        String url = builder.toString();
        request.setAttribute("url", url);
        PageInfo<Book> pageInfo=new PageInfo<Book>(books);
        request.getSession().setAttribute("pageInfo", pageInfo);
       // modelAndView.setViewName("/client/index.jsp");
        request.getRequestDispatcher("/client/index.jsp").forward(request,response);


    }

}
