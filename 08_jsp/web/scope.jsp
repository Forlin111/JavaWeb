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
    <h1>scope.jsp页面</h1>
    <%
        //往4个域中存放数据
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>

    pageContext:    <%=pageContext.getAttribute("key")%><br>
    request:    <%=request.getAttribute("key")%><br>
    session:    <%=session.getAttribute("key")%><br>
    application:    <%=application.getAttribute("key")%>
    <%--<%
        request.getRequestDispatcher("/scope1.jsp").forward(request,response);
    %>--%>
    <%--jsp请求转发--%>
    <jsp:forward page="/scope1.jsp"></jsp:forward>
</body>
</html>
