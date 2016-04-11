<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>
<title>${page.title}</title>

<c:if test="${not empty page.title}">
    <h1>${page.title}</h1>
</c:if>

<c:if test="${not empty page.breadcrumbs}">
    <ol class="breadcrumb">
        <c:forEach items="${page.breadcrumbs}" var="breadcrumb" varStatus="status">
            <c:choose>
                <c:when test="${status.last}">
                    <li class="active">${breadcrumb.label}</li>
                </c:when>
                <c:otherwise>
                    <li><a href="${breadcrumb.href}">
                            ${breadcrumb.label}
                    </a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </ol>
</c:if>

<c:forEach items="${page.components}" var="component">
    <page:component component="${component}"/>
</c:forEach>
