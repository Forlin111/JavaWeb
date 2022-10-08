<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/17
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8085/13_cookie/loginServlet" method="get" >
        用户名:<input type="text" name="username" value="${cookie.username.value}"><br>
        密码:<input type="password" name="password"><br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
