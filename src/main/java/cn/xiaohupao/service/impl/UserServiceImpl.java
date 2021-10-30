package cn.xiaohupao.service.impl;

import cn.xiaohupao.dao.UserDao;
import cn.xiaohupao.domain.User;
import cn.xiaohupao.service.UserService;
import cn.xiaohupao.utils.Encode;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        user.setPassword(Encode.encodeByMd5(user.getPassword()));
        userDao.addUser(user);
    }

    @Override
    public User queryLogin(String userName, String password) {
        return userDao.queryLogin(userName, Encode.encodeByMd5(password));
    }

    @Override
    public void deleteUserById(Integer userId) {
        userDao.deleteUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        user.setPassword(Encode.encodeByMd5(user.getPassword()));
        userDao.updateUser(user);
    }

    @Override
    public PageInfo<User> queryAll(User user, Integer pageSize, Integer pageNum) {
        //设置查询的时间
        String[] dateRange = user.getDateRange();
        if (dateRange != null){
            user.setBegin(dateRange[0]);
            user.setEnd(dateRange[1]);
        }

        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.queryAll(user);
        return new PageInfo<>(users);
    }

    @Override
    public User queryById(Integer userId) {
        return userDao.queryById(userId);
    }
}
