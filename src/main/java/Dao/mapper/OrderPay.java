package Dao.mapper;

import Pojo.Order;
import Pojo.Order_item;

public interface OrderPay {
    //保存订单项
    public int saveOrderItem(Order_item order_item);
    //保存订单类
    public int saveOrder(Order order);
}
