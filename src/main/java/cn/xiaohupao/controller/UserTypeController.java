package cn.xiaohupao.controller;

import cn.xiaohupao.domain.UserType;
import cn.xiaohupao.service.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/26 19:21
 */
@RestController
@RequestMapping("/userType")
public class UserTypeController {

    private final UserTypeService userTypeService;

    @Autowired
    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping("queryAll")
    public List<UserType> queryAll(){
        return userTypeService.queryAll();
    }
}
