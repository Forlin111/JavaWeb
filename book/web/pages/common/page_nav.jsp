<%--
  Created by IntelliJ IDEA.
  User: 琳
  Date: 2022/8/4
  Time: 5:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="page_nav">
    <a href="${requestScope.page.url}&pageNo=1">首页</a>
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    【${requestScope.page.pageNo}】
    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
    </c:if>

    <%--页码输出的开始--%>
    <c:choose>
        <%--如果总页码小于等于5,页码的范围是:1-总页码--%>
        <c:when test="${requestScope.page.pageTotal<=5}">
            <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${i==requestScope.page.pageNo}">
                    【${i}】
                </c:if>
                <c:if test="${i!=requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
        <%--当总页码大于5,这里以10为例--%>
        <c:when test="${requestScope.page.pageTotal>5}">
            <c:choose>
                <%--当页码为前面三个,页码范围为1-5--%>
                <c:when test="${requestScope.page.pageNo<=3}">
                    <c:forEach begin="1" end="5" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <%--当页码为最后三个时,页码范围是总页码-4 - 总页码--%>
                <c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">
                    <c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:when>
                <%--3,4,5,6,7,页码范围为当前页码-2 -当前页码+2--%>
                <c:otherwise>
                    <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            【${i}】
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录 到第<input value="${param.page.pageNo}"
                                                                                     name="pn"
                                                                                     id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script>
        $(function () {
            $("#searchPageBtn").click(function () {
                let pageNo = $("#pn_input").val();
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
            })
        })
    </script>
</div>