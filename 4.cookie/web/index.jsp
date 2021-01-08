<%--
  Created by IntelliJ IDEA.
  User: 左璧莹
  Date: 2021/1/7
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%
    int i = 5;
    System.out.println("hello Jsp");
    String contextPath = request.getContextPath();
    out.print(contextPath);
    out.print(12345);
  %>
  <%!
  int i = 3;
  %>
  <%="hello"%>
  <%
    response.getWriter().write("response...");
  %>
  </body>
</html>
