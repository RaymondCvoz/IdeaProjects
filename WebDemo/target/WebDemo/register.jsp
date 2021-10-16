<%--
  Created by IntelliJ IDEA.
  User: Sranc
  Date: 9/10/2021
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>

</head>
<body>
<form action="Login" method="post">
    <table>
        <tr>
            <td><input type="text" name="UserName" placeholder="请输入用户名"></td>
        </tr>
        <tr>
            <td><input type="text" name="Password" placeholder="请输入密码"></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
            <td><input type="hidden" name="mode" value="register"></td>
        </tr>
    </table>
</form>
</body>
</html>
