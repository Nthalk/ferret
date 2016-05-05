<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags-page" tagdir="/WEB-INF/tags/page" %>
<%@ attribute name="page" type="com.iodesystems.ferret.web.models.Page" %>


<title>${page.title}</title>

<c:if test="${not empty page.sidebar}">
    <style>
        .sidebar {
            position: fixed;
            top: 0;
            left: 0;
            bottom: 0;
            background: #2e3032;
            width: 150px;
        }

        .sidebar-nav {
            list-style: none;
            margin: 0;
            padding: 0;
        }

        .sidebar-nav > li {
            color: #dddddd;
            padding-left: 20px;
            padding-bottom: 10px;
            font-size: 18px;
            margin: 10px 0;
            border-bottom: 1px solid #515151;
        }

        .sidebar-content {
            margin-left: 150px;
        }
    </style>

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
</c:if>

<div class="container-fluid ${not empty page.sidebar ? 'sidebar-content' : ''}">
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
