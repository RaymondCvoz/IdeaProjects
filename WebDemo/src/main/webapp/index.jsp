<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
            <td><input type="submit" value="登录"></td>
            <td><input type="hidden" name="mode" value="login"></td>
        </tr>
    </table>
    <p>
        <a href="register.jsp">注册新用户</a>
    </p>
</form>
</body>
</html>
