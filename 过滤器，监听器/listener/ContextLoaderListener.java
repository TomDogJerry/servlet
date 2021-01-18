package com.hqyj.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /**
     * 监听servletContext创建的
     * servletContext对象服务器启动后自动创建
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载资源文件
        //1.获取servletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();
        //2.加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        //3.获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
        //4.加载到内存中
        try {
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("servletContext对象被创建了");
    }

    /**
     * 服务器关闭后，servletContext对象销毁，
     * 服务器正常关闭后，contextDestroyed会调用
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("servletContext对象销毁了");
    }
}
