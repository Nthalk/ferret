<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fer" tagdir="/WEB-INF/tags/fer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>DataSources</title>
</head>
<body>
<jsp:useBean id="dataSourcesIndex" scope="request" type="com.iodesystems.ferret.web.controllers.models.DataSourcesIndex"/>

<div class="container">
    <fer:table page="${dataSourcesIndex.dataSources}">
        <jsp:attribute name="paginationUrl">${spring:mvcUrl("dataSources").arg(1,page).build()}</jsp:attribute>
        <jsp:attribute name="header">
        <tr>
            <th>Name</th>
            <th>Schemas</th>
        </tr>
        </jsp:attribute>
        <jsp:attribute name="ifNone">
            <tr>
                <td colspan="2">
                    <div class="well text-center">
                        No DataSources found
                    </div>
                </td>
            </tr>
        </jsp:attribute>
        <jsp:attribute name="row">
            <jsp:useBean id="item" scope="request" type="com.iodesystems.ferret.models.DataSource"/>
            <tr>
                <td><a href="${spring:mvcUrl("dataSourceShow").arg(0,item.id).build()}">${item.name}</a></td>
                <td>${item.schemaCount}</td>
            </tr>
        </jsp:attribute>
    </fer:table>

</div>
</body>
</html>
