package cn.xiaohupao.service;

import cn.xiaohupao.domain.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/24 20:05
 */
public interface UserService {

    void addUser(User user);
    User queryLogin(String userName, String password);
    void deleteUserById(Integer userId);
    void updateUser(User user);
    PageInfo<User> queryAll(User user, Integer pageSize, Integer pageNum);
    User queryById(Integer userId);
}
