package Service;

import Pojo.User;

public interface UserLoginAndRegistServiel {
    User logins(String username, String password);
    int regist(User user);
    User lookUser(String username);
}
