<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--导包动作--%>
<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/12
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page
    errorPage="/error500.html"
    pageEncoding="UTF-8"
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--jsp声明脚本(java代码)--%><%--可以给jsp翻译出来的Java类定义方法和属性,甚至是静态代码块,内部类--%>

    <%--声明类属性:--%>
    <%!
        private int id;
        private String name;
        private static Map<String,Object> map;
    %>
    <%--声明静态代码块--%>
    <%!
        static {
            map=new HashMap<String,Object>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
            map.put("key4","value4");
        }
    %>
    <%--声明类方法--%>
    <%!
        public String name(){
            return "黄慧静";
        }
    %>
    <%--声明内部类--%>
    <%!
        public static class A{
            private Integer id=1;
            private String name="黄慧静";
        }
    %>

    <%--表达式脚本--%><%--在jsp页面上输出数据--%>
    <%=12%>
    <%="黄慧静"%>
    <%=2.31%>
    <%=map%><%--输出对象--%><br>
    <%=request.getParameter("username")%><%--service()中的对象可以直接用;--%>

    <%--代码脚本--%>
    <%--if语句--%>
    <%
        int a=10;
        if (a == 10) {
            System.out.println("true");
            response.getWriter().write("true");
        }else {
            System.out.println("false");
        }
    %>
    <%--for循环--%>
    <%
        for (int i = 0; i < 5; i++) {
            System.out.print(i+"\t");
        %>
            <%=i%>
        <%
        }
        %>
    <%--jspService()中的代码都可以写--%>
    <%
        System.out.println(request.getParameter("name"));
    %>

</body>
</html>
