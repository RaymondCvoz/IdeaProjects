<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <form action="dispatch" method="post">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
            </tr>
            <tr>
                <td><input type="hidden" name="dispatchType" value="login"></td>
            </tr>
        </table>
    </form>

    <a href="Account/UserRegister.jsp">注册</a>

</body>
</html>
