<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="dispatch" method="post">
    <table>
        <tr>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>
    <input type="hidden" name="dispatchType" value="login">
</form>
<p>用户：test 密码：test</p>
</body>
</html>
