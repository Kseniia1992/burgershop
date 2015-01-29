<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Burger Shop</title>
    <link rel="stylesheet" href="css/common.css"/>
    <!--[if IE]>
    <script>
        document.createElement('header');
        document.createElement('nav');
        document.createElement('section');
        document.createElement('article');
        document.createElement('aside');
        document.createElement('footer');
    </script>
    <![endif]-->
</head>

<body>
<div class="bg_main">

    <div class="bg">

        <header class="main">
            <div class="logo_line"></div>
            <div class="menu">
                <spring:message text="Hi "/> <sec:authentication property="name"/> <sec:authentication property="authorities"/>
                <a href="logout" style="text-decoration: none; color: #ffffff">  Log out</a>
            </div>
            <img src="img/logo.png"/>
            <button class="but" onclick="location.href='shop.html'"> Make your own <br>burger now!</button>
            <button id="orders" class="but" onclick="location.href='userOrders.html'"> Orders <br></button>
        </header>
    </div>

    <section class="main">
        <img src="img/advertise_block.png"/>
    </section>

</div>
<!-- don't cached jsp page -->
<%
    response.setHeader("pragma","no-cache");
    response.setHeader("Cache-control","no-cache, no-store, must-revalidate");
    response.setHeader("Expires","0");
%>
</body>
</html>