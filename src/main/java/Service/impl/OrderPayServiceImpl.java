package Service.impl;

import Dao.mapper.BookManager;
import Dao.mapper.OrderPay;
import Pojo.*;
import Service.OrderPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service("orderPayService")
public class OrderPayServiceImpl implements OrderPayService {
    @Autowired
    OrderPay orderPay;
    @Autowired
    BookManager bookManager;

    public String creatorder(Cart cart, Integer userid) {
        String orderId=System.currentTimeMillis()+""+userid;
        Order order=new Order(orderId,new Date(),cart.getTotalPrice(),0,userid);
        orderPay.saveOrder(order);
        //把商品项都转化为订单项
        for(Map.Entry<Integer, CartItem>entry:cart.getItem().entrySet()){
            CartItem value = entry.getValue();
            Order_item order_item=new Order_item(null,value.getName(),value.getCount(),value.getPrice(),value.getPriceTotal(),orderId);
            orderPay.saveOrderItem(order_item);
            //库存，销量修改
            Book book= bookManager.queryByid(value.getId());
            book.setSales(book.getSales()+value.getCount());
            book.setStock(book.getStock()-value.getCount());
            bookManager.updateBook(book);

        }
        //清楚购物车
        cart.clear();



        return orderId;
    }
}
