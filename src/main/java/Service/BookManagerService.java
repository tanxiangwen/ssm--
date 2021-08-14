package Service;

import Pojo.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookManagerService {
    List<Book> listByPage();
    int updateBook(Book book);
    Book queryByid(int id);
    int delete(int id);
    int addBook(Book book);
}
