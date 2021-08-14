package Pojo;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 购物车
 * 有总商品数量
 * 总金额
 * 集合存储商品信息
 */
public class Cart {
    int totalCount;
    BigDecimal totalPrice;//所有商品价格
    Map<Integer,CartItem> item=new HashMap<Integer, CartItem>();

    /**
     * 获取所有商品数量
     * @return
     */

    public int getTotalCount() {
       //集合遍历
        int totalCount=0;
        for(Map.Entry<Integer,CartItem> entry:item.entrySet()){
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }


    /**
     * 获取购物车金额
     * @return
     */
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice=new BigDecimal(0);
        for(Map.Entry<Integer,CartItem> entry:item.entrySet()){
            totalPrice=totalPrice.add(entry.getValue().getPriceTotal());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItem() {
        return item;
    }

    public void setItem(Map<Integer, CartItem> item) {
        this.item = item;
    }
    //购物车方法
    public void addItem(CartItem cartItem){
              //首先判断购物车中有没有此物
        CartItem cartItem1 = item.get(cartItem.getId());
        if(cartItem1==null){
            //说明没有，添加进去
            item.put(cartItem.getId(),cartItem);
        }else{
            //说明存在，修改数量，价格
            cartItem1.setCount(cartItem1.getCount()+1);
            cartItem1.setPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem1.getCount())));
        }

    }
    //商品删除
    public void delete(int id){
        item.remove(id);
    }
    //商品数量引起价格，总价格变化
    public void update(int id,int count){
        CartItem cartItem = item.get(id);
        if(cartItem!=null){
            //修改数量和总价格
            cartItem.setCount(count);
            cartItem.setPriceTotal(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }
    //清空
    public void clear(){
        item.clear();
    }

}
