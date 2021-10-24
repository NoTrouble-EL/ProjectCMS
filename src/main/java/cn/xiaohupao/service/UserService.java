package cn.xiaohupao.service;

import cn.xiaohupao.domain.User;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/24 20:05
 */
public interface UserService {

    void addUser(User user);
    User queryLogin(String userName, String password);
    void deleteUserById(int userId);
    void updateUser(User user);
    List<User> queryAll(User user);
    User queryById(int userId);
}
