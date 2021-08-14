package Dao.mapper;

import Pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 图书管理
 */
public interface BookManager {
    //展示全部图书并分页
    List<Book> listByPage();
    //根据id查找图书
    Book queryByid(int id);
    int updateBook(Book book);
    int delete(int id);
    //添加图书
    int addBook(Book book);

}
