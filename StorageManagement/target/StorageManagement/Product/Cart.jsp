<%@ page import="java.util.Map" %>
<%@ page import="com.google.protobuf.MapEntry" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
  <% Map<String,Integer> cartDetails = (Map<String, Integer>) session.getAttribute("CartDetails");
      Map<String,String> cartDetailsName = (Map<String, String>) session.getAttribute("CartDetailsName");%>

  <table border="1px" align="center">
      <tr>
          <td>商品名称</td>
          <td>商品数量</td>
          <td>操作</td>
      </tr>
<%
    if(cartDetails != null && cartDetailsName != null)
    for(Map.Entry<String, Integer> entry : cartDetails.entrySet())
    {
%>
      <tr>
          <td><%=cartDetailsName.get(entry.getKey())%></td>
          <td><%=entry.getValue()%></td>
          <td>
              <form action="../service/CartHandler?req=delete" method="post">
                  <input type="hidden" value="<%=entry.getKey()%>" name="ProductId">
                  <input type="submit" value="从购物车中删除" >
              </form>
          </td>
      </tr>
<%
    }
%>
    <tr>
        <td><a href="service/CartHandler?req=check">结算</a></td>、
        <td><a href="ProductGallery.jsp">返回</a></td>
    </tr>
  </table>
</body>
</html>
