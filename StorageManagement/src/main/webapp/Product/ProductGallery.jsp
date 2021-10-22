<%@ page import="java.util.List" %>
<%@ page import="entities.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>产品信息</title>
</head>
<body>
    <%
        List<Object> result = (List<Object>) session.getAttribute("productList");
    %>
    <table>
        <%
            for(Object object : result)
            {
                Product current = (Product) object;
        %>
                <tr>
                    <td><%=current.getName()%></td>
                    <td><%=current.getStatus()%></td>
                    <td><%=current.getPrice()%></td>
                </tr>
        <%
            }
        %>
    </table>
</body>
</html>
