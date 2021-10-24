package cn.xiaohupao.dao;

import cn.xiaohupao.domain.User;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/24 19:54
 */
public interface UserDao {

    /**
     * 增加用户
     * @param user 用户信息对象
     */
    void addUser(User user);

    /**
     * 登录查询用户
     * @param userName 用户名
     * @param password 密码
     * @return 用户对象
     */
    User queryLogin(String userName, String password);

    /**
     * 根据Id删除用户
     * @param userId 用户Id
     */
    void deleteUserById(int userId);

    /**
     * 根据用户信息更新用户
     * @param user 用户信息对象
     */
    void updateUser(User user);

    /**
     * 根据用户信息来查询
     * @param user 用户信息
     * @return 符合条件的用户
     */
    List<User> queryAll(User user);

    /**
     * 根据用户Id来查询用户
     * @param userId 用户Id
     * @return 用户信息对象
     */
    User queryById(int userId);
}
