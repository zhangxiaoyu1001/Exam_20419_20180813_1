package dao;

import entity.User;

public interface UserDao {
    /***
     * 用户登陆的方法声明
     * @param user
     * @return
     */
    public User login(User user);
}
