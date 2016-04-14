<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags-page" tagdir="/WEB-INF/tags/page" %>
<%@ attribute name="page" type="com.iodesystems.ferret.web.models.Page" %>


<title>${page.title}</title>

<div id="sidebar-wrapper">
    <c:if test="${not empty page.sidebar}">
        <div id="sidebar">
            <div class="sidebar">
                <c:forEach items="${page.sidebar.menuGroups}" var="itemGroup">
                    <ul class="sidebar-nav">
                        <li class="sidebar-brand">${itemGroup.title}</li>
                        <c:forEach items="${itemGroup.menuItems}" var="item">
                            <li><a href="${item.href}">${item.label}</a></li>
                        </c:forEach>
                    </ul>
                </c:forEach>
            </div>
        </div>
    </c:if>

    <div id="sidebar-page-content">
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
    </div>
</div>
