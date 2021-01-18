package com.hqyj.web.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //1.创建真实对象
        Lenovo lenovo = new Lenovo();
        //2.动态代理增强Lenovo真实对象
        /**
         * 三个参数
         * 1.类加载器：lenovo.getClass().getClassLoader()
         * 2.接口数组：lenovo.getClass().getInterfaces()
         * 3.处理器：new InvocationHandler() {}
         */
        SaleComputer proxy_lenovo =(SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*
                代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法的执行
                参数：
                1.proxy：代理对象
                2.method代理对象调用的方法，被封装为的对象
                3.args:代理对象调用方法时传递的实际参数
                 */
                System.out.println(method.getName());
                System.out.println(args[0]);
                //判断是否是sale方法
                if (method.getName().equals("sale")) {
                    //1.增强参数
                    double money = (double) args[0];
                    money = money * 0.85;
                    //使用真实对象调用该方法
                    String str = (String) method.invoke(lenovo, money);
                    return str + "_鼠标垫";
                } else {
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }

            }
        });
        //3.调用方法
        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);
    }
}
