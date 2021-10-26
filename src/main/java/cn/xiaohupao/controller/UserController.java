package cn.xiaohupao.controller;

import cn.xiaohupao.domain.User;
import cn.xiaohupao.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/24 20:08
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public User queryLogin(@RequestBody User user, HttpServletRequest request){
        System.out.println(user);
        HttpSession session =request.getSession();
        session.setAttribute("userId", user.getUserId());
        return userService.queryLogin(user.getUserName(), user.getPassword());
    }

    @GetMapping("queryUserById/{id}")
    public User queryUserById(@PathVariable("id") int id){
        return userService.queryById(id);
    }

    @PostMapping("update")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        userService.deleteUserById(id);
    }

    @PostMapping("add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PostMapping("queryAll/{pageSize}/{pageNum}")
    public PageInfo<User> queryAll(@RequestBody User user, @PathVariable("pageSize") Integer pageSize, @PathVariable("pageNum") Integer pageNum){
        return userService.queryAll(user, pageSize, pageNum);
    }

}
