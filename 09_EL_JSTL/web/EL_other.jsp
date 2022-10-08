<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/14
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--EL内置隐含对象--%>

    <%--获取请求参数的值--%>
    输出请求参数name的值:${param.name}<br>
    <%--获取多个请求参数值时--%>
    ${paramValues.name[0]}<br>
    <hr>
    <%--获取请求头--%>
    ${header['User-Agent']}<br>
    ${headerValues['User-Agent'][0]}<br>
    ${header['Host']}<br>
    <hr>
    <%--获取initparam值--%>
    ${initParam}<br>
    ${initParam.name}<br>
    ${initParam.name1}<br>
</body>
</html>
