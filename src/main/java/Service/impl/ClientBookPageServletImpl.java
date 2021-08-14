package Service.impl;

import Dao.mapper.ClientBookPage;
import Pojo.Book;
import Service.ClientBookPageServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("clientBookPageServlet")
public class ClientBookPageServletImpl implements ClientBookPageServlet {
    @Autowired
    ClientBookPage clientBookPage;
    public List<Book> list() {
         return clientBookPage.list();
    }

    public List<Book> byPrice(int min, int max) {
        return clientBookPage.byPrice(min, max);
    }
}
