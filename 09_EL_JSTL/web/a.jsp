<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/14
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("key","value");
    %>
    jsp表达式输出:<%=request.getAttribute("key1")==null?"":request.getAttribute("key")%><br>
    EL表达式输出:${key1}
</body>
</html>
