package cn.xiaohupao.service.impl;

import cn.xiaohupao.dao.UserTypeDao;
import cn.xiaohupao.domain.UserType;
import cn.xiaohupao.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/26 19:19
 */
@Service
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeDao userTypeDao;

    @Autowired
    public UserTypeServiceImpl(UserTypeDao userTypeDao) {
        this.userTypeDao = userTypeDao;
    }

    @Override
    public List<UserType> queryAll() {
        return userTypeDao.queryAll();
    }
}
