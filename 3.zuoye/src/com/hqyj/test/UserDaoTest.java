package com.hqyj.test;

import com.hqyj.dao.UserDao;
import com.hqyj.domain.User;
import org.junit.Test;

/**
 * 测试类
 */
public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("zuobiying");
        loginUser.setPassword("1234");
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);

    }
}
