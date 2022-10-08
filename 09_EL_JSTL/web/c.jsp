<%@ page import="pojo.person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/7/14
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        person person = new person();
        ArrayList<String> list = new ArrayList<>();
        list.add("长沙");
        list.add("深圳");
        list.add("广州");
        HashMap<String, Object> map = new HashMap<>();
        map.put("key1","rog全家桶");
        map.put("key2","键盘");
        map.put("key3","鼠标");
        person.setName("黄慧静");
        person.setPhones(new String[]{"1123456","2344567"});
        person.setCities(list);
        person.setMap(map);
        pageContext.setAttribute("person",person);
    %>
    输出person类数据:<br>${person}
    输出person类的name属性:${person.name}<br>
    输出person类的phone的数组属性值:${person.phones[0]}<br>
    输出person类的cities集合属性值:${person.cities[1]}<br>
        输出person类的map属性值:${person.map.key1}<br>
</body>
</html>
