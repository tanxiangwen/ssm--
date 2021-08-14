package Dao.mapper;

import Pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserLoginAndRegist {
     User logins(@Param("username") String username, @Param("password") String password);
     int regist(User user);
     User lookUser(String username);
}
