<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="component"
             scope="request"
             type="com.iodesystems.ferret.web.models.components.EntitySearchTable"/>

<form:form method="get" modelAttribute="component">
    <div class="input-group">
        <form:input path="query"
                    placeholder="Search"
                    cssClass="form-control"/>
        <div class="input-group-addon">
            <button type="submit" style="padding:0; border: 0; background: transparent">
                <i class="glyphicon glyphicon-search"></i>
            </button>
        </div>
    </div>
    <hr/>
    <table class="table table-striped table-bordered table-condensed">
        <thead>
        <tr>
            <c:forEach items="${component.entityDefinition.fieldDefinitions}" var="fieldDefinition">
                <th>${fieldDefinition.name}</th>
            </c:forEach>
        </tr>
        </thead>
        <tbody>

        <c:choose>
            <c:when test="${empty component.searchResult.data}">
                <tr>
                    <td colspan="${component.entityDefinition.fieldDefinitions.size()}"
                        class="text-center">
                        <div class="well-lg">
                            No results found
                        </div>
                    </td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach items="${component.searchResult.data}" var="row">
                    <tr>
                        <c:forEach items="${row.fields}" var="field">
                            <td>
                                    ${field.value}
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</form:form>
