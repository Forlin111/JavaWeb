<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.student" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/15
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--JSTL标签库使用--%>
<%--set标签可以往域中保存数据
    域对象.setattribute(可以,value)--%>
保存之前:${requestScope.key}<br>
<c:set scope="request" var="key"  value="hhj"/> <%--page是域对象,var是key,value是value--%>
保存之后:${requestScope.key}<br>
<hr>

    <%--多分路判断跟switch差不多--%>
    <%--注意要使用jsp注释,when标签的父标签一定要是choose标签;--%>
    <%
        request.setAttribute("height","165");
    %>
    <c:choose>
        <c:when test="${requestScope.height>190}">
            <h2>小巨人</h2>
        </c:when>
        <c:when test="${requestScope.height>180}">
            <h2>很高</h2>
        </c:when>
        <c:when test="${requestScope.height>170}">
            <h2>还可以</h2>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="${requestScope.height>160}">
                    <h2>小人</h2>
                </c:when>
            </c:choose>
        </c:otherwise>
    </c:choose>

    <hr>
    <%--forEach遍历--%>
    <%--遍历1-10--%>
    <%--
        begin为开始索引
        end为结束索引
        var为循环变量
    --%>
    <c:forEach begin="1" end="10" var="i">
        ${i}
    </c:forEach>
    <hr>
    <%--遍历数组
        items是数据源
        var表示当前遍历到的数据
    --%>
    <%
        request.setAttribute("arr",new String[]{"123","234","456"});
    %>
<br>
    <c:forEach items="${requestScope.arr}" var="item">
        ${item}
    </c:forEach>
<hr>
    <%--遍历map集合--%>
    <%
        HashMap<Object, Object> map = new HashMap<>();
        map.put("key1","hhj1");
        map.put("key2","hhj2");
        map.put("key3","hhj3");
        map.put("111","hhj4");
        request.setAttribute("map",map);
    %>
    <c:forEach items="${requestScope.map}" var="map">
        ${map.key}=${map.value} &nbsp;
    </c:forEach>
<hr>
    <%--遍历list集合--%>
    <%
        List<student> list = new ArrayList<>();
        for (int i = 1; i <=10; i++) {
            list.add(new student(i,"name"+i,"pwd"+i,17+i,"123450"+i));
        }
        request.setAttribute("list",list);
    %>
<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>密码</th>
        <th>年龄</th>
        <th>号码</th>
    </tr>
        <%--可以实现起始索引输出,
        step表示步长值就是for循环的i++
        设置值可以让循环跳几个值输出--%>
    <c:forEach begin="3" end="8" step="2" items="${requestScope.list}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.pwd}</td>
            <td>${list.age}</td>
            <td>${list.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
