package Service.impl;

import Dao.mapper.BookManager;
import Pojo.Book;
import Service.BookManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("bookManagerService")
public class BookManagerServiceImpl implements BookManagerService {
    @Autowired
    BookManager bookManager;
    public List<Book> listByPage() {
        return bookManager.listByPage();

    }

    public int  updateBook(Book book) {
        return bookManager.updateBook(book);
    }

    public Book queryByid(int id) {
        return bookManager.queryByid(id);
    }

    public int delete(int id) {return bookManager.delete(id);
    }

    public int addBook(Book book) {
         return bookManager.addBook(book);
    }
}
