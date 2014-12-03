<%@ page import="de.zaunberg.burgershop.service.ShopService" %>
<%@ page import="de.zaunberg.burgershop.service.ShopServiceImpl" %>
<%@ page import="de.zaunberg.burgershop.model.UserOrder" %>
<%@ page import="java.util.List" %>
<%@ page import="java.security.Principal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Burger Shop</title>
</head>
<body>
<h1>User's orders</h1>
<%
    Principal principal = request.getUserPrincipal();

    ShopServiceImpl shopServiceImpl = new ShopServiceImpl();
    List<UserOrder> list = shopServiceImpl.findUserOrder(principal.getName());
%>
<table>
    <tr>
        <th>Burger</th>
        <th>Price</th>
    </tr>

</table>
</body>
</html>
