<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/14
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--El获取4个域对象数据--%>
    <%
        pageContext.setAttribute("key1","pageContext");
    %>
    ${key1}<br><%--第一种方式,key1为域的别名--%>
    ${pageScope.key1}<%--第二种--%>
    <%--可以选择性的输出某个域中的数据--%>
</body>
</html>
