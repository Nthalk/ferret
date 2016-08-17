<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fer" tagdir="/WEB-INF/tags/fer" %>
<%@ taglib prefix="url" tagdir="/WEB-INF/tags/url" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>DataSources</title>
</head>
<body>
<jsp:useBean id="dataSourcesIndex" scope="request" type="com.iodesystems.ferret.web.controllers.models.DataSourcesIndex"/>

<div class="container">
    <fer:table page="${dataSourcesIndex.dataSources}">
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
                        No DataSources found, would you like to <a href="<c:url value="/data-sources/create"/>">add one</a>?
                    </div>
                </td>
            </tr>
        </jsp:attribute>
        <jsp:attribute name="row">
            <jsp:useBean id="item" scope="request" type="com.iodesystems.ferret.models.DataSource"/>
            <tr>
                <td><a href="<c:url value="/data-sources/${item.id}"/>">${item.name}</a></td>
                <td>${item.schemaCount}</td>
            </tr>
        </jsp:attribute>
    </fer:table>

</div>
</body>
</html>
