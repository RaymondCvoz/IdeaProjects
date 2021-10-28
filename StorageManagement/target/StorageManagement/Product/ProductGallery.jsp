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
    <table border="1px" align="center">
        <%
            if(result != null)
            for(Object object : result)
            {
                Product current = (Product) object;
        %>
                <tr>
                    <td>产品名称</td>
                    <td>产品价格</td>
                    <td>操作</td>
                </tr>
                <tr>
                    <td><%=current.getName()%></td>
                    <td><%=current.getPrice()%></td>
                    <td>
                        <form action="../service/CartHandler?req=add" method="post">
                            <input type="hidden" value="<%=current.getId()%>" name="ProductId">
                            <input type="hidden" value="<%=current.getName()%>" name="ProductName">
                            <input type="submit" value="加入购物车">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td><a href="Cart.jsp">查看购物车</a></td>
                </tr>
        <%
            }
        %>
    </table>
</body>
</html>
