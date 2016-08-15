<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="dataSourceAddSchema" scope="request" type="com.iodesystems.ferret.web.controllers.models.DataSourceAddSchema"/>

<html>
<head>
    <title>DataSource: ${dataSourceAddSchema.dataSource.name}</title>
</head>
<body>

<div class="container">
    <h1>${dataSourceAddSchema.dataSource.name}</h1>
    <form:form modelAttribute="dataSourceAddSchema" method="post">
        <fieldset>
            <legend>Add Schema</legend>
            <form:hidden path="schema.dataSourceId"/>
            <div class="form-group">
                <form:label class="col-lg-2 control-label" path="schema.name">
                    Name of schema <form:errors path="schema.name"/>
                </form:label>
                <div class="col-lg-6">
                    <form:input path="schema.name"
                                class="form-control"
                                placeholder="Schema Name"/>
                </div>
            </div>
        </fieldset>
        <div class="text-right">
            <a class="btn btn-default" href="${spring:mvcUrl("dataSourceShow").arg(0,dataSourceAddSchema.dataSource.id).build()}">Back</a>
            <button type="submit" class="btn btn-success">Add Schema</button>
        </div>
    </form:form>
</div>
</body>
</html>
