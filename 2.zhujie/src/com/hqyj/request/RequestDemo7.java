package com.hqyj.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo7")
public class RequestDemo7 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo7被访问了....");
        //转发到demo8资源
/*
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/requestDemo8");
        requestDispatcher.forward(req,resp);*/
        //存储数据到request域中
        req.setAttribute("msg","hello");
        req.getRequestDispatcher("/requestDemo8").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
