<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.student" %><%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/13
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    table {
        border: 1px red solid;
        width: 1000px;
        height: 300px;
        border-collapse: collapse;
    }

    td {
        border: 1px green solid;
    }
    ##aaa{
        border: 2px pink solid;
     }
</style>
<body>
<%
    int id = 0;
    String name = "lisa";
    List<pojo.student> students = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
        students.add(new student(id + i, name + String.valueOf(i), 17 + i, String.valueOf(123456780 + i)));
    }
%>
<table align="center">
    <tr id="#aaa">
        <td align="center">id</td>
        <td align="center">name</td>
        <td align="center">age</td>
        <td align="center">number</td>
    </tr>
    <%for (student student : students) {%>
    <tr>
        <td align="center"><%=student.getId()%>
        </td>
        <td align="center"><%=student.getName()%>
        </td>
        <td align="center"><%=student.getAge()%>
        </td>
        <td align="center"><%=student.getNumber()%>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
