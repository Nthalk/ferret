<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>

<jsp:useBean id="component"
             type="com.iodesystems.ferret.web.models.components.Table"
             scope="request"/>

<c:set var="table" value="${component}"/>

<table class="table table-bordered table-striped table-condensed">
    <c:if test="${not empty table.columnHeaders}">
        <thead>
        <tr>
            <c:forEach items="${table.columnHeaders}" var="columnHeader">
                <th>
                    <page:component component="${columnHeader.content}"/>
                </th>
            </c:forEach>
        </tr>
        </thead>
    </c:if>
    <c:if test="${not empty table.rows}">
        <tbody>
        <c:forEach items="${table.rows}" var="row">
            <tr ${not empty row.id ? 'id="'.concat(row.id).concat('"'): ''}>
                <c:forEach items="${row.cells}" var="cell">
                    <td>
                        <page:component component="${cell.content}"/>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
        </tbody>
    </c:if>
</table>
