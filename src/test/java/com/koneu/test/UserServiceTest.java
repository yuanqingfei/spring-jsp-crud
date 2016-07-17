package com.koneu.test;

import com.koneu.WebApplication;
import com.koneu.order.Order;
import com.koneu.order.OrderStatus;
import com.koneu.user.User;
import com.koneu.user.UserExistException;
import com.koneu.user.UserService;
import com.koneu.user.UserTypeEnum;
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
public class UserServiceTest {

    @Autowired
    UserService userService;

    User user;

    String id;

    @Before
    public void setUp(){
        user = new User();
        User user = new User();
        this.user.setName("testUserName");
        this.user.setPassword("111");
        this.user.setLocked(false);
        this.user.setType(UserTypeEnum.NORMAL);
    }

    @After
    public void shutDown(){
        if(id != null){
            userService.deleteUser(id);
        }
    }

    @Test
    public void testCrud() throws UserExistException {
        Assert.assertNotNull(userService);
        user = userService.register(user);

        id = user.getId();
        Assert.assertNotNull(id);
        System.out.println("id: " + id);

        List<User> users = userService.getAll();
        Assert.assertTrue(users.size() > 0);

        user.setType(UserTypeEnum.ADMIN);
        userService.update(user);
        user = userService.getUser(Long.valueOf(id));

        System.out.println(user.getType());
        Assert.assertTrue(UserTypeEnum.ADMIN.equals(user.getType()));
    }
}
