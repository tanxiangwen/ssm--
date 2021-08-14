package Service;

import Pojo.Book;

import java.util.List;

public interface ClientBookPageServlet {
    List<Book>list();
    List<Book> byPrice(int min,int max);
}
