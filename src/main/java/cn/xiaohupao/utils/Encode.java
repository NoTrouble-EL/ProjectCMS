package cn.xiaohupao.utils;

import org.springframework.util.DigestUtils;

/**
 * @Author: xiaohupao
 * @Date: 2021/10/30 10:17
 */
public class Encode {

    public static String encodeByMd5(String password){
        String salt = "52018991nsl?12206991kw";
        String saltPassword = salt + "/" + password;
        return DigestUtils.md5DigestAsHex(saltPassword.getBytes());
    }
}
