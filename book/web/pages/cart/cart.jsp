<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%--静态包含公共部分--%>
    <%@include file="/pages/common/head.jsp" %>
    <script>
        $(function () {
            $("a.deleteItem").click(function () {
                return confirm("确定删除[" + $(this).parent().parent().find("td:first").text() + "]嘛?")
            })
            $("a.clearCart").click(function () {
                return confirm("是否清空购物车!!!")
            })
            $("input.updateCount").change(function () {
                let name=$(this).parent().parent().find("td:first").text();
                let count=$(this).val();
                let id=$(this).attr("bookId");
                if (confirm("是否将["+name+"]修改数量为"+count)==false){
                    //defaultValue是表单dom对象的默认值
                     this.value=this.defaultValue;
                }else {
                    location.href="http://localhost:8088/book/cartServlet?action=updateCount1&count="+count+"&id="+id;
                }
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">购物车</span>
    <%--静态包含登录成功后的菜单--%>
    <%@include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${sessionScope.cart.items}" var="entry">
            <tr>
                <td>${entry.value.name}</td>
                <td>
                    <input class="updateCount" bookId="${entry.value.id}" style="width: 80px" type="text" name="" id="" value="${entry.value.count}">
                </td>
                <td>${entry.value.price}</td>
                <td>${entry.value.totalPrice}</td>
                <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
            </tr>
        </c:forEach>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">购物车为空</a></td>
            </tr>
        </c:if>
    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a class="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
        </div>
    </c:if>

</div>

<%@include file="/pages/common/footer.jsp" %>
</body>
</html>