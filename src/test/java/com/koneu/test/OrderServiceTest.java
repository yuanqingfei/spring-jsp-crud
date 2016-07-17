package com.koneu.test;

import com.koneu.WebApplication;

import com.koneu.order.Order;
import com.koneu.order.OrderService;
import com.koneu.order.OrderStatus;
import com.koneu.user.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by aaron on 16-7-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WebApplication.class)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    Order order;

    String id;

    @Before
    public void setUp(){
        order = new Order();
        User user = new User();
        order.setOrderBy(1L);
        order.setOrderDate(new Date());
        order.setOrderStatus(OrderStatus.CREATED);
        order.setSubtotal(20.9);
    }

    @After
    public void shutDown(){
        if(id != null){
            orderService.delete(id);
        }
    }

    @Test
    public void testCrud(){
        Assert.assertNotNull(orderService);
        order = orderService.insert(order);

        id = order.getId();
        Assert.assertNotNull(id);
        System.out.println("id: " + id);

        List<Order> videos = orderService.getAll();
        Assert.assertTrue(videos.size() > 0);

        order.setOrderStatus(OrderStatus.PAID);
        orderService.update(order);
        order = orderService.get(id);

        System.out.println(order.getOrderStatus());
        Assert.assertTrue(OrderStatus.PAID.equals(order.getOrderStatus()));
    }    
}
