<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/12
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--在jsp页面统一使用out.print()来进行输出,避免打乱数据的输出顺序--%>
</head>
<body>
        <%--jsp中out输出和response输出的区别--%>
    <%
        out.print("out1<br>");
        out.print("out2<br>");

        response.getWriter().write("response1<br>");
        response.getWriter().write("response2<br>");
    %>
        <%--out和responose输出会分别输出到各自的缓冲区,但当jsp页面所有代码完成后会做两个操作
        1,执行out.flush操作,将out缓冲区的数据追加到response缓冲区末尾
        2,执行response的刷新操作,将全部数据写给客户端
        所以这就是out写的内容一直在response后的原因了--%>
</body>
</html>
