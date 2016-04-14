<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags-page" tagdir="/WEB-INF/tags/page" %>
<%@ attribute name="page" type="com.iodesystems.ferret.web.models.Page" %>


<title>${page.title}</title>

<c:if test="${not empty page.navigation}">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">${page.navigation.title}</a>
        </div>
    </nav>
</c:if>

<c:if test="${not empty page.sidebar}">
    <div class="sidebar">
        <c:forEach items="${page.sidebar.menuGroups}" var="itemGroup">
            ${itemGroup.title}
            <ul>
                <c:forEach items="${itemGroup.menuItems}" var="item">
                    <li><a href="${item.href}">${item.label}</a></li>
                </c:forEach>
            </ul>
        </c:forEach>
    </div>
</c:if>

<div class="container-fluid">
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
        <tags-page:component component="${component}"/>
    </c:forEach>
</div>
