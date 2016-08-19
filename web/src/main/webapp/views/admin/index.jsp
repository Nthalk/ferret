<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fer" tagdir="/WEB-INF/tags/fer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="adminIndex" scope="request" type="com.iodesystems.ferret.web.controllers.models.AdminIndex"/>
<html>
<head>
    <title>Title</title>
</head>
<body>

<style>
    .navTree {
        border: 1px solid #e7e7e7;
        border-top: 0;
        margin-top: -20px;
        display: inline-block;
    }

    .navTree .header {
        background-color: rgba(207, 207, 207, 0.65);
        border-bottom: 1px solid #cfcfcf;
        font-weight: bolder;
    }

    .navTree .header.search {
        font-weight: normal;;
    }

    .navTree ul, .navTree li {
        list-style: none;
        margin: 0;
        padding: 0;
    }

    .navTree li, .navTree .header {
        padding: 10px;
    }

</style>
<div class="navTree">
    <div class="header search">
        <input class="form-control search" placeholder="Search"/>
    </div>
    <div class="header">
        DataSources
        <a href="<c:url value="/admin/ajax/data-source-create"/>" class="btn btn-success btn-xs pull-right"
                                                                          data-target="#dataSourceCreateModal"
                                                                          data-toggle="modal"><i class="fa fa-plus fa-1"></i></a>
    </div>
    <ul>
        <c:forEach var="dataSource" items="${adminIndex.navTree.children}">
            <li>
                <i class="fa fa-server fa-1" aria-hidden="true"></i> ${dataSource.label}
                <a href="<c:url value="/admin/ajax/data-source-manage"/>" class="btn btn-default btn-xs pull-right"
                   data-target="#dataSourceManage"
                   data-toggle="modal"><i class="fa fa-cog fa-1"></i></a>
                <ul>
                    <c:forEach var="schema" items="${dataSource.children}">
                        <li>
                            <i class="fa fa-database fa-1" aria-hidden="true"></i> ${schema.label}
                            <ul>
                                <c:forEach var="table" items="${schema.children}">
                                    <i class="fa fa-table fa-1" aria-hidden="true"></i> ${table.label}
                                </c:forEach>
                            </ul>
                        </li>
                    </c:forEach>
                </ul>
            </li>
        </c:forEach>
    </ul>
</div>

<div id="dataSourceCreateModal" class="modal modal-fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="loader" style="font-size: 10px"></div>
        </div>
    </div>
</div>

</body>
</html>
