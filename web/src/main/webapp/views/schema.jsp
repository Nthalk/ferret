<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fer" tagdir="/WEB-INF/tags/fer" %>
<%@ taglib prefix="url" tagdir="/WEB-INF/tags/url" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="schemaShow" scope="request" type="com.iodesystems.ferret.web.controllers.models.SchemaShow"/>

<html>
<head>
    <title>Schema: ${schemaShow.schema.name}</title>
</head>
<body>

<div class="container">
    <h1>${schemaShow.schema.name}</h1>
    <h3>Schemas</h3>
    <fer:table page="${schemaShow.tables}">
        <jsp:attribute name="header">
        <tr>
            <th>Name</th>
            <th>Fields</th>
        </tr>
        </jsp:attribute>
        <jsp:attribute name="ifNone">
            <tr>
                <td colspan="2">
                    <div class="well text-center">
                        No schemas found, <a href="${spring:mvcUrl("tableAddField").arg(0,schemaShow.schema.id).build()}">add one</a>?
                    </div>
                </td>
            </tr>
        </jsp:attribute>
        <jsp:attribute name="row">
            <jsp:useBean id="item" scope="request" type="com.iodesystems.ferret.models.Schema"/>
            <tr>
                <td><a href="<c:url value="/tables/${item.id}"/>">${item.name}</a></td>
                <td>${item.tableCount}</td>
            </tr>
        </jsp:attribute>
        <jsp:attribute name="paginationUrl">
            <jsp:useBean id="page" scope="request" type="java.lang.Integer"/>
            <url:replaceParam name="tablesPage" value="${page}"/>
        </jsp:attribute>
    </fer:table>
</div>
</body>
</html>