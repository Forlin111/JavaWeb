<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/13
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 600px;
        }
    </style>
</head>
<body>
    <%--输出99乘法表--%>
    <h1 align="center">九九乘法表</h1>
    <table align="center">
        <%
        for (int i = 1; i <=9; i++) {%>
            <tr>
                <%
            for (int j = 1; j <=i; j++) {%>
                <td><%=j+"x"+i+"="+(j*i)%></td>
            <%}%>
            </tr>
        <%}%>
    </table>
</body>
</html>