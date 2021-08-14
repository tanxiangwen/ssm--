package Pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单类
 */
public class Order {
    String order_id;//订单编号
    Date create_time;//创建时间
    BigDecimal total_money;//总价钱
    int status=0;//状态:0:未发货
    int user_id;//订单的收件人id

    public Order(String order_id, Date create_time, BigDecimal total_money, int status, int user_id) {
        this.order_id = order_id;
        this.create_time = create_time;
        this.total_money = total_money;
        this.status = status;
        this.user_id = user_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public BigDecimal getTotal_money() {
        return total_money;
    }

    public void setTotal_money(BigDecimal total_money) {
        this.total_money = total_money;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", create_time=" + create_time +
                ", total_money=" + total_money +
                ", status=" + status +
                ", user_id=" + user_id +
                '}';
    }
}
