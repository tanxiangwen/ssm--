package Dao.mapper;

import Pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台图书分页以及展示
 */
public interface ClientBookPage {
    List<Book> list();
    List<Book> byPrice(@Param("min") int min, @Param("max") int max);
}
