<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/27
  Time: 8:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--动态获取base标签--%>
<%
    String basePath=request.getScheme()+
            "://"+
            request.getServerName()+":"+
            request.getServerPort()+
            request.getContextPath()+
            "/";
    pageContext.setAttribute("basePath",basePath);
%>

<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script src="static/jquery-3.6.0.js"></script>
