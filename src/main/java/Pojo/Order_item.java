package Pojo;

import java.math.BigDecimal;

/**
 * 订单项
 */
public class Order_item {
    Integer id;//订单id
    String name;//商品名字
    int count;//总数
    BigDecimal price;//价格
    BigDecimal total_money;//总金额
    String order_id;//订单号

    public Order_item(Integer id, String name, int count, BigDecimal price, BigDecimal total_money, String order_id) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.total_money = total_money;
        this.order_id = order_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal_money() {
        return total_money;
    }

    public void setTotal_money(BigDecimal total_money) {
        this.total_money = total_money;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Order_item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", total_money=" + total_money +
                ", order_id=" + order_id +
                '}';
    }
}
