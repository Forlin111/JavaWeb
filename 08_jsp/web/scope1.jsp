<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/12
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope1.jsp页面</h1>

    pageContext:    <%=pageContext.getAttribute("key")%><br>
    request:    <%=request.getAttribute("key")%><br>
    session:    <%=session.getAttribute("key")%><br>
    application:    <%=application.getAttribute("key")%>

</body>
</html>
