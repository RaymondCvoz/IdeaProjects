<%--
  Created by IntelliJ IDEA.
  User: Sranc
  Date: 9/10/2021
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<%
    String loginStatus = (String) session.getAttribute("LoginStatus");
    if(loginStatus == null || !loginStatus.equals("success"))
    {
        response.sendRedirect("errorPage.jsp");
    }
%>

<h1>欢迎</h1>
</body>
</html>
