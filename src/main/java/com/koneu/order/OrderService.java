package com.koneu.order;

import com.koneu.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by aaron on 16-7-17.
 */
@Component
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    public List<Order> getAll(){
        return orderMapper.getAll();
    }

    public Order get(String id){
        return orderMapper.get(Long.valueOf(id));
    }

    public Order update(Order c){
        String id = c.getId();
        Assert.notNull(id);
        orderMapper.update(Long.valueOf(id), c);
        return c;
    }

    public void delete(String id){
        orderMapper.delete(Long.valueOf(id));
    }


    public Order insert(Order c){
        orderMapper.insert(c);
        return c;
    }

    public List<OrderItem> getOrderItems(String id){
        return orderItemMapper.getByOrderId(Long.valueOf(id));
    }

    public void insertOrderItem(String id, OrderItem item){
        item.setOrderId(id);
        orderItemMapper.insert(item);
    }

    public void deleteOrderItems(String id){
        List<OrderItem> items = getOrderItems(id);
        for(OrderItem item : items){
            orderItemMapper.delete(Long.valueOf(item.getId()));
        }
    }

    public void updateOrderItems(String id, List<OrderItem> items){
        deleteOrderItems(id);
        for(OrderItem item : items){
            item.setOrderId(id);
            orderItemMapper.insert(item);
        }
    }
}
