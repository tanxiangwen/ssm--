package Service.impl;

import Dao.mapper.UserLoginAndRegist;
import Pojo.User;
import Service.UserLoginAndRegistServiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userLoginAndRegistServiel")
public class UserLoginAndRegistServiceImpl implements UserLoginAndRegistServiel {
    /**
     * 用户登录
     */
   @Autowired
   private UserLoginAndRegist userLoginAndRegist;
    public User logins(String username, String password) {
        return userLoginAndRegist.logins(username, password);

    }

    public int regist(User user) {
        return userLoginAndRegist.regist(user);
    }

    /**
     * 看是否存在用户名
     * @param username
     * @return
     */
    public User lookUser(String username) {
        return userLoginAndRegist.lookUser(username);
    }
}
