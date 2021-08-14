package Dao.mapper;

import Pojo.Book;
import org.springframework.stereotype.Controller;

public interface Cart {
    Book queryById(int id);

}
