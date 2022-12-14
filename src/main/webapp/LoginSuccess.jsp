<%--
  Created by IntelliJ IDEA.
  User: ULLASKUMAR K
  Date: 14-12-2022
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<h3>Hi <%= request.getAttribute("user") %>, Login Successful.</h3>
<a href="index.html"> Login page </a>
</body>
</html>