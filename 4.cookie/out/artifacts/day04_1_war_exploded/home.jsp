<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: 左璧莹
  Date: 2021/1/7
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一访问</title>
</head>
<body>
<%
    //1.获取所有的cookie
    Cookie[] cookies = request.getCookies();
    boolean flag = false;//没有cookie为lasttime
    //2.遍历cookie数组
    if(cookies!=null&&cookies.length>0){
        for (Cookie cookie : cookies) {
            //3.获取cookie的名称
            String name = cookie.getName();
            //4.判断名称是否是lastTime
            if("lastTime".equals(name)){
                //有该cookie,不是第一次访问
                flag = true;//有lastTime的cookie
                //响应数据
                //获取cookie的value，时间
                String value = cookie.getValue();
                //URL解码
                value = URLDecoder.decode(value, "utf-8");
                response.getWriter().write("<h1>欢迎回来，您上次访问时间为:"+value+"</h1>");

                //设置Cookie的value值
                //获取当前的时间的字符串，重新设置cookie的值，重新发送cookie
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date = sdf.format(date);
                //URL编码
                System.out.println("编码前："+str_date);
                str_date = URLEncoder.encode(str_date, "utf-8");
                System.out.println("编码后："+str_date);
                cookie.setValue(str_date);

                //设置cookie的存活时间
                cookie.setMaxAge(60*60*24*30);//一个月
                response.addCookie(cookie);

                break;

            }

        }


    }
    if(cookies==null||cookies.length==0||flag==false){
        //没有，第一次访问
        //设置Cookie的value值
        //获取当前的时间的字符串，重新设置cookie的值，重新发送cookie
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);
        //URL编码
        System.out.println("编码前："+str_date);
        str_date= URLEncoder.encode(str_date, "utf-8");
        System.out.println("编码后："+str_date);
        Cookie cookie = new Cookie("lastTime",str_date);
        //设置cookie的存活时间
        cookie.setMaxAge(60*60*24*30);//一个月
        response.addCookie(cookie);

        response.getWriter().write("<h1>您好，欢迎您首次访问!</h1>");
    }
%>
<input type="button" name="a">
</body>
</html>
