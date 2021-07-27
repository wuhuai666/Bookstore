<%--
  Created by IntelliJ IDEA.
  User: 吴淮
  Date: 2021/7/20
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <%--		若当前不是在首页,则才显示首页的按钮--%>
    <c:if test="${requestScope.Page.pageNo>1}">
        <a href="${requestScope.Page.url}&PageNo=1" >首页</a>
        <a href="${requestScope.Page.url}&PageNo=${requestScope.Page.pageNo-1}">上一页</a>
        <%--			<a href="${requestScope.Page.url}&PageNo=${requestScope.Page.pageNo-1}">${requestScope.Page.pageNo-1}</a>--%>
    </c:if>
    <c:choose>
        <%--			 总页码小于等于5的情况,页码的范围为1-5--%>
        <c:when test="${requestScope.Page.pageTotal<=5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.Page.pageTotal}"/>
        </c:when>
        <%--		总页码大于5的情况  假设一共十页 分三种情况:	--%>
        <c:when test="${requestScope.Page.pageTotal>5}">
            <c:choose>
                <%--					 当前页码为前面三个：1，2，3   范围是1-5--%>
                <c:when test="${requestScope.Page.pageNo<=3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--					 2、当前页码为后三个:8,9,10     范围：总页码-4至总页码--%>
                <c:when test="${requestScope.Page.pageNo>requestScope.Page.pageTotal-3}">
                    <c:set var="begin" value="${requestScope.Page.pageTotal-4}"/>
                    <c:set var="end" value="${requestScope.Page.pageTotal}"/>
                </c:when>
                <%--					 3、4，5，6，7          范围：当前页码-2 到当前页码加2--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.Page.pageNo-2}"/>
                    <c:set var="end" value="${requestScope.Page.pageNo+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <
    <c:forEach begin="${begin}" end="${end}" var="i">
        <%--           当为当前页码时,不可点击--%>
        <c:if test="${i==requestScope.Page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i!=requestScope.Page.pageNo}">
            <a href="${requestScope.Page.url}&PageNo=${i}" >${i} &nbsp; </a>
        </c:if>
    </c:forEach>
    >
    <c:if test="${requestScope.Page.pageNo<requestScope.Page.pageTotal}">
        <%--			<a href="${requestScope.Page.url}&PageNo=${requestScope.Page.pageNo+1}">${requestScope.Page.pageNo+1}</a>--%>
        <a href="${requestScope.Page.url}&PageNo=${requestScope.Page.pageNo+1}" >下一页</a>
        <a href="${requestScope.Page.url}&PageNo=${requestScope.Page.pageTotal}" >末页</a>
    </c:if>
    共${requestScope.Page.pageTotal}页，${requestScope.Page.pageTotalCount}条记录
    到第<input  name="pn" id="pn_input"/>页
    <input type="button" id="search" value="确定">
</div>
<script type="text/javascript">
    $(function () {
        //为跳转到指定页码的确定按钮绑定单击事件
        $("#search").click(function () {
            //获取方框中的值
            var pageNo=$("#pn_input").val();
            //location.href 跳转至指定的连接
            location.href="${pageContext.getAttribute("basePath")}${requestScope.Page.url}&PageNo="+pageNo;
        });
    });

</script>
