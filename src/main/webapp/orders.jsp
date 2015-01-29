<!DOCTYPE html>
<%@ page import="de.zaunberg.burgershop.model.UserOrder" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Burger Shop</title>
    <link rel="stylesheet" type="text/css" href="css/common.css" />
</head>
<body class="inner_bg">
<header class="main">
    <div class="logo_line"></div>
    <img src="img/logo.png"/>
</header>

<%
   ArrayList<String> list = (ArrayList<String>) request.getAttribute("orders");
%>
<div class="table">

    <div class="tr">
        <div class="th">Bread</div>
        <div class="th">Meat</div>
        <div class="th">Extras</div>
        <div class="th">Price</div>
    </div>

    <div class="tr">
        <%
            Iterator itr = list.iterator();
            while (itr.hasNext()){
                Object[] obj = (Object[]) itr.next();
                UserOrder uo = (UserOrder) obj[0];
        %>
        <div class="td"><%=uo.getChoice1()%></div>
        <div class="td"><%=uo.getChoice2()%></div>
        <div class="td"><%=uo.getChoice3()%></div>
        <div class="td"><%=uo.getTotalprice()%></div>
    </div>
    <%
        }
    %>
</div>

</body>
</html>
