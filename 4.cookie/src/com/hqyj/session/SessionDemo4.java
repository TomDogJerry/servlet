package com.hqyj.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/sessionDemo4")
public class SessionDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用Session共享数据
        //1.获取session
        HttpSession session = request.getSession();
        System.out.println(session);
        //org.apache.catalina.session.StandardSessionFacade@5acdb266
        //org.apache.catalina.session.StandardSessionFacade@2a51507f


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
