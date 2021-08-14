package Control;

import Pojo.Book;
import Service.BookManagerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import utils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 图书后台管理
 */
@Controller
public class BookManager {
    @Autowired
    BookManagerService bookManagerService;
    @RequestMapping("/listBook")
    /**
     * 展示图书
     */
    public ModelAndView listBook(int pageNo, HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        PageHelper.startPage(pageNo, 4);
        List<Book> books = bookManagerService.listByPage();
        for (Book book : books) {
            request.getSession().setAttribute("book",books);


        }
        PageInfo<Book> pageInfo=new PageInfo<Book>(books);
        request.getSession().setAttribute("pageInfoBook", pageInfo);
        modelAndView.setViewName("/pages/manager/book_manager.jsp");
        return modelAndView;


    }
    /**
     * 查出要修改的图书，并回显数据到表单
     */
    @RequestMapping("/showBook")
    public ModelAndView show(int id,HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        //查找
        Book book = bookManagerService.queryByid(id);
        //保存
        request.setAttribute("bookById",book);
        modelAndView.setViewName("/pages/manager/book_edit.jsp");
        return modelAndView;


    }
   /**
     * 图书修改
     */
    @RequestMapping("/updatebook")
    public void updateBook(Book book, HttpServletRequest request, HttpServletResponse response) throws IOException {
      // int Id= BeanUtils.parsins(request.getParameter("id"),1000000000);
        int i = bookManagerService.updateBook(book);
      PageInfo pageInfo=(PageInfo)  request.getSession().getAttribute("pageInfoBook");
        int pageNum = pageInfo.getPageNum();
        response.sendRedirect(request.getContextPath()+"/listBook?pageNo="+pageNum);



    }
    @RequestMapping("/deleteBook")
    public void delete(int id,HttpServletResponse response,HttpServletRequest request) throws IOException {
        bookManagerService.delete(id);
        PageInfo pageInfo=(PageInfo)  request.getSession().getAttribute("pageInfoBook");
        int pageNum = pageInfo.getPageNum();
        response.sendRedirect(request.getContextPath()+"/listBook?pageNo="+pageNum);


    }
    /**
     * 添加图书
     *
     */
    @RequestMapping("/addBook")
    public ModelAndView addBook(Book book,HttpServletRequest request,HttpServletResponse response) throws IOException {
        ModelAndView modelAndView=new ModelAndView();
        int i = bookManagerService.addBook(book);

        if(i==1) {
            //保存图书信息
            request.setAttribute("BookInf", book);
            //转发到图书管理页
            modelAndView.setViewName("listBook?pageNo=1");
        }else{
            response.sendRedirect(request.getHeader("Referer"));
        }
        return modelAndView;



    }


}
