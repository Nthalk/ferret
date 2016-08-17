<%@tag description="Table" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="url" tagdir="/WEB-INF/tags/url" %>
<%@attribute name="header" required="true" fragment="true" %>
<%@attribute name="row" required="true" fragment="true" %>
<%@attribute name="ifNone" required="false" fragment="true" %>
<%@attribute name="paginationUrl" required="false" fragment="true" %>
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

            <c:set var="p" value="${page.page}"/> <%-- current page (1-based) --%>
            <c:set var="l" value="7"/> <%-- amount of page links to be displayed --%>
            <c:set var="r" value="${l / 2}"/> <%-- minimum link range ahead/behind --%>
            <c:set var="t" value="${page.totalPages}"/> <%-- total amount of pages --%>

            <c:set var="begin" value="${((p - r) > 0 ? ((p - r) < (t - l + 1) ? (p - r) : (t - l)) : 0) + 1}"/>
            <c:set var="end" value="${(p + r) < t ? ((p + r) > l ? (p + r) : l) : t}"/>

            <nav>
                <ul class="pagination">
                    <c:if test="${page.page > 1}">
                        <c:set var="pageNumber" scope="request" value="${page.page - 1}"/>
                        <c:choose>
                            <c:when test="${empty paginationUrl}">
                                <c:set var="paginationUrlValue"><url:replaceParam name="page" value="${pageNumber}"/></c:set>
                            </c:when>
                            <c:otherwise>
                                <jsp:invoke fragment="paginationUrl" var="paginationUrlValue"/>
                            </c:otherwise>
                        </c:choose>
                        <li><a href="${paginationUrlValue}">&laquo;</a></li>
                    </c:if>
                    <c:forEach var="pageNumber" begin="${begin}" end="${end}">
                        <c:choose>
                            <c:when test="${pageNumber == page.page}">
                                <li class="active"><a>${pageNumber}</a></li>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${empty paginationUrl}">
                                        <c:set var="paginationUrlValue"><url:replaceParam name="page" value="${pageNumber}"/></c:set>
                                    </c:when>
                                    <c:otherwise>
                                        <c:set var="pageNumber" scope="request" value="${pageNumber}"/>
                                        <jsp:invoke fragment="paginationUrl" var="paginationUrlValue"/>
                                    </c:otherwise>
                                </c:choose>
                                <li><a href="${paginationUrlValue}">${pageNumber}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${page.page < page.totalPages}">
                        <c:set var="pageNumber" scope="request" value="${page.page + 1}"/>
                        <c:choose>
                            <c:when test="${empty paginationUrl}">
                                <c:set var="paginationUrlValue"><url:replaceParam name="page" value="${pageNumber}"/></c:set>
                            </c:when>
                            <c:otherwise>
                                <jsp:invoke fragment="paginationUrl" var="paginationUrlValue"/>
                            </c:otherwise>
                        </c:choose>
                        <li><a href="${paginationUrlValue}">&raquo;</a></li>
                    </c:if>
                </ul>
            </nav>
        </c:if>
    </div>
</c:if>
