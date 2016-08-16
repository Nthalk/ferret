<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fer" tagdir="/WEB-INF/tags/fer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="dataSourceShow" scope="request" type="com.iodesystems.ferret.web.controllers.models.DataSourceShow"/>

<html>
<head>
    <title>DataSource: ${dataSourceShow.dataSource.name}</title>
</head>
<body>

<div class="container">
    <h1>${dataSourceShow.dataSource.name}</h1>
    <h3>Schemas</h3>
    <fer:table page="${dataSourceShow.schemas}">
        <jsp:attribute name="header">
        <tr>
            <th>Name</th>
            <th>Tables</th>
        </tr>
        </jsp:attribute>
        <jsp:attribute name="ifNone">
            <tr>
                <td colspan="2">
                    <div class="well text-center">
                        No schemas found, <a href="<c:url value="/data-sources/${dataSourceShow.dataSource.id}/schemas/create"/>">add one</a>?
                    </div>
                </td>
            </tr>
        </jsp:attribute>
        <jsp:attribute name="row">
            <jsp:useBean id="item" scope="request" type="com.iodesystems.ferret.models.Schema"/>
            <tr>
                <td><a href="<c:url value="/data-sources/${dataSourceShow.dataSource.id}/schemas/${item.id}"/>">${item.name}</a></td>
                <td>${item.tableCount}</td>
            </tr>
        </jsp:attribute>
        <jsp:attribute name="paginationUrl">
            <jsp:useBean id="page" scope="request" type="java.lang.Integer"/>
            <c:url value="/data-sources/${dataSourceShow.dataSource.id}?schemasPage=${page}"/>
        </jsp:attribute>
    </fer:table>
</div>
</body>
</html>
