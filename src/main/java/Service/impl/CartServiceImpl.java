package Service.impl;

import Pojo.Book;
import Dao.mapper.Cart;
import Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    Cart cart;
    public Book queryById(int id) {
         return cart.queryById(id);
    }
}
