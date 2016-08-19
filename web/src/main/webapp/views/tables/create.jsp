<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="tableCreate" scope="request" type="com.iodesystems.ferret.web.controllers.models.TableCreate"/>

<html>
<head>
    <title>Table Create</title>
</head>
<body>

<div class="container">
    <h1>${tableCreate.dataSource.name} / ${tableCreate.schema.name}</h1>
    <form:form modelAttribute="tableCreate" method="post" cssClass="form-horizontal">
        <fieldset>
            <legend>Add Table</legend>
            <form:hidden path="table.id"/>
            <form:hidden path="table.schemaId"/>
            <div class="form-group">
                <form:label class="col-lg-2 control-label" path="dataSource.name">
                    Name of Table <form:errors path="table.name"/>
                </form:label>
                <div class="col-lg-6">
                    <form:input path="table.name"
                                class="form-control"
                                placeholder="Table Name"/>
                </div>
            </div>
        </fieldset>
        <div class="text-right">
            <a class="btn btn-default" href="<c:url value="/data-sources/${tableCreate.dataSource.id}/schemas/${tableCreate.schema.id}"/>">Back</a>
            <button type="submit" class="btn btn-success">Add Table</button>
        </div>
    </form:form>
</div>
</body>
</html>
