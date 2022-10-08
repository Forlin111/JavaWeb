<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/13
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <%--静态包含:
        把一个页面单独包含,在另外一个jsp页面展示,方便以后更新及维护;
    --%>
<body>
    头部信息<br>
    主体内容<br>
    <%--这就是静态包含--%>
    <%--<%@include file="footer.jsp"%>--%>
    <%--这是动态包含,可以传递参数--%>
    <jsp:include page="footer.jsp">
        <jsp:param name="username" value="hhj"/>
        <jsp:param name="age" value="18"/>
    </jsp:include>


</body>
</html>
