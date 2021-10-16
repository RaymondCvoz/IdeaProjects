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

    <form action="dispatch" method="post">
        <input type="submit" value="注册">
        <input type="hidden" name = "dispatchType" value="register">
    </form>

</body>
</html>
