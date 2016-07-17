package com.koneu.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by aaron on 16-7-3.
 */
@Component
public class UserService {


    @Autowired
    private UserMapper userDao;

//    @Autowired
//    private LoginLogDao loginLogDao;


    /**
     * 注册一个新用户,如果用户名已经存在此抛出UserExistException的异常
     * @param user
     */
    public User register(User user) throws UserExistException{
        User u = this.getUserByUserName(user.getName());
        if(u != null){
            throw new UserExistException("用户名已经存在");
        }else{
//            user.setCredit(100);
            user.setLocked(false);
            user.setLastVisit(new Date());
            user.setType(UserTypeEnum.NORMAL);
            userDao.insert(user);
            return user;
        }
    }

    /**
     * 更新用户
     * @param user
     */
    public void update(User user){
        userDao.update(Long.valueOf(user.getId()), user);
    }


    /**
     * 根据用户名/密码查询 User对象
     * @param userName 用户名
     * @return User
     */
    public User getUserByUserName(String userName){
        return userDao.getByName(userName);
    }


    /**
     * 根据userId加载User对象
     * @param userId
     * @return
     */
    public User getUser(Long userId){
        return userDao.get(userId);
    }

    /**
     * 将用户锁定，锁定的用户不能够登录
     * @param userName 锁定目标用户的用户名
     */
    public void lock(String userName){
        User user = userDao.getByName(userName);
        user.setLocked(true);
        update(user);
    }

    /**
     * 解除用户的锁定
     * @param userName 解除锁定目标用户的用户名
     */
    public void unlock(String userName){
        User user = userDao.getByName(userName);
        user.setLocked(false);
        update(user);
    }


    /**
     * 根据用户名为条件，执行模糊查询操作
     * @param userName 查询用户名
     * @return 所有用户名前导匹配的userName的用户
     */
    public List<User> queryUserByUserName(String userName){
        return userDao.queryByName(userName);
    }

    /**
     * 获取所有用户
     * @return 所有用户
     */
    public List<User> getAll(){
        return userDao.getAll();
    }

    /**
     * 登陆成功
     * @param user
     */
    public void loginSuccess(User user) {
//        user.setCredit( 5 + user.getCredit());
//        LoginLog loginLog = new LoginLog();
//        loginLog.setUser(user);
//        loginLog.setIp(user.getLastIp());
//        loginLog.setLoginDate(new Date());
//        userDao.update(user);
//        loginLogDao.save(loginLog);
    }

    public void deleteUser(String id){
        userDao.delete(Long.valueOf(id));
    }
}
