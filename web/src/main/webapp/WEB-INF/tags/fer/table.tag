<%@tag description="Table" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="header" required="true" fragment="true" %>
<%@attribute name="row" required="true" fragment="true" %>
<%@attribute name="ifNone" required="false" fragment="true" %>
<%@attribute name="paginationUrl" required="true" fragment="true" %>
<%@attribute name="page" required="true" type="com.iodesystems.ferret.query.Page" %>

<table class="table">
    <thead>
    <jsp:invoke fragment="header"/>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${empty page.items}">
            <jsp:invoke fragment="ifNone"/>
        </c:when>
        <c:otherwise>
            <c:forEach var="item" items="${page.items}">
                <c:set var="item" scope="request" value="${item}"/>
                <jsp:invoke fragment="row"/>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>
<c:if test="${not empty page.items}">
    <div class="text-right">
        <div class="pull-left">
            <c:if test="${page.start > 0}">
                ${page.start} to
            </c:if>
                ${page.end} of ${page.resultCount} results
            <c:if test="${page.resultCount ne page.totalCount}">
                (${page.totalCount - page.resultCount} filtered out)
            </c:if>
        </div>
        <c:if test="${page.totalPages > 1}">
            <nav>
                <ul class="pagination">
                    <c:forEach var="page" begin="1" end="${page.totalPages}">
                        <c:set var="page" scope="request" value="${page}"/>
                        <li><a href="<jsp:invoke fragment="paginationUrl"/>">${page}</a></li>
                    </c:forEach>
                </ul>
            </nav>
        </c:if>
    </div>
</c:if>
