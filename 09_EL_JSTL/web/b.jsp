<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/14
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--EL表达式在4个域中搜索数据的顺序 ：按以下顺序执行--%>
    <%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");//要关掉浏览器重新打开才能看到下一个域中的效果
        application.setAttribute("key","application");
    %>
    ${
    key
    }
</body>
</html>
