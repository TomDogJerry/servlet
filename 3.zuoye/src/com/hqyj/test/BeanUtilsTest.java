package com.hqyj.test;

import com.hqyj.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * BeanUtils的getProperty()和setProperty()
 */
public class BeanUtilsTest {
    @Test
    public void test(){
        User user= new User();
        try {
            //BeanUtils.setProperty(user,"username","lixian");
            BeanUtils.setProperty(user,"hehe","male");
            System.out.println(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
