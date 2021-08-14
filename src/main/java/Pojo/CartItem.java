package Pojo;

import java.math.BigDecimal;

/**
 * 购物车中商品信息属性
 */
public class CartItem {
    Integer id;
    String name;
    int count;
    BigDecimal price;
    BigDecimal priceTotal;

    public CartItem(Integer id, String name, int count, BigDecimal price, BigDecimal priceTotal) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.priceTotal = priceTotal;
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

    public BigDecimal getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(BigDecimal priceTotal) {
        this.priceTotal = priceTotal;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", priceTotal=" + priceTotal +
                '}';
    }
}
