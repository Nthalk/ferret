<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>
<jsp:useBean id="component"
             type="com.iodesystems.ferret.web.models.components.grid.GridRow"
             scope="request"/>
<div class="row">
    <c:forEach var="column" items="${component.columns}">
        <div class="col-xs-${column.width}${column.offset == 0 ? "" : " col-xs-offset-".concat(column.offset)}">
            <c:forEach var="columnComponent" items="${column.components}">
                <page:component component="${columnComponent}"/>
            </c:forEach>
        </div>
    </c:forEach>
</div>
