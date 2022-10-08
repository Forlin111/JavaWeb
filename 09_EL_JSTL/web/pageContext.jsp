<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/14
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    pageContext的作用;<br>
    <%=request.getScheme()%><%--等价于下面的El表达式--%><br>
    1.协议:${pageContext.request.scheme}<br>
    2.服务器IP:${pageContext.request.serverName}<br>
    3.端口号:${pageContext.request.serverPort}<br>
    4.工程路径:${pageContext.request.contextPath}<br>
    5.文件路径:${pageContext.request.servletPath}<br>
    6.IP地址:${pageContext.request.remoteHost}<br>
    7.会话的id:${pageContext.request.session.id}<%--会话的唯一标识--%>
</body>
</html>
