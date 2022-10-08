<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/14
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%request.setAttribute("att",null);%>
    ${empty att}
    <%--中括号运算--%>
    <%
        HashMap<String, Object> map = new HashMap<>();
        map.put("a.a.a","value1");
        map.put("b.b.b","value2");
        map.put("c.c.c","value3");
        request.setAttribute("map",map);
    %>
    ${map['b.b.b']}
</body>
</html>
