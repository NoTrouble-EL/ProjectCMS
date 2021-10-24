package cn.xiaohupao.service.impl;

import cn.xiaohupao.dao.UserDao;
import cn.xiaohupao.domain.User;
import cn.xiaohupao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/24 20:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User queryLogin(String userName, String password) {
        return userDao.queryLogin(userName, password);
    }

    @Override
    public void deleteUserById(int userId) {
        userDao.deleteUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> queryAll(User user) {
        return userDao.queryAll(user);
    }

    @Override
    public User queryById(int userId) {
        return userDao.queryById(userId);
    }
}
