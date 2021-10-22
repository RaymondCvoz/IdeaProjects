<%--
  Created by IntelliJ IDEA.
  User: Sranc
  Date: 10/15/2021
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
    <form action="../dispatch" method="post">
        <table>
            <tr>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="注册"></td>
            </tr>
        </table>
        <input type="hidden" name="dispatchType" value="register">
    </form>
    ${sessionScope.userExistInfo}
</body>
</html>
