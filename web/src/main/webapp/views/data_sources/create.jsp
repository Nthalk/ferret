<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="dataSourceCreate" scope="request" type="com.iodesystems.ferret.web.controllers.models.DataSourceCreate"/>

<html>
<head>
    <title>DataSource Create</title>
</head>
<body>

<div class="container">
    <h1>${dataSourceCreate.dataSource.name}</h1>
    <form:form modelAttribute="dataSourceCreate" method="post" cssClass="form-horizontal">
        <fieldset>
            <legend>Add DataSource</legend>
            <form:hidden path="dataSource.id"/>
            <div class="form-group">
                <form:label class="col-lg-2 control-label" path="dataSource.name">
                    Name of DataSource <form:errors path="dataSource.name"/>
                </form:label>
                <div class="col-lg-6">
                    <form:input path="dataSource.name"
                                class="form-control"
                                placeholder="DataSource Name"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 control-label">
                    Access Type
                </label>
                <div class="col-lg-6">
                    <div class="radio">
                        <label>
                            <form:radiobutton
                                    path="dataSource.accessType"
                                    value="JNDI"/>
                            JNDI
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <form:radiobutton
                                    path="dataSource.accessType"
                                    value="JDBC"/>
                            JDBC
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <form:label class="col-lg-2 control-label" path="dataSource.allowModifySchemas">
                    Modify Schemas<form:errors path="dataSource.allowModifySchemas"/>
                </form:label>
                <div class="col-lg-6">
                    <form:checkbox path="dataSource.allowModifySchemas" cssStyle="margin-top:11px"/>
                </div>
            </div>
        </fieldset>
        <div class="text-right">
            <a class="btn btn-default" href="<c:url value="/data-sources"/>">Back</a>
            <button type="submit" class="btn btn-success">Add DataSource</button>
        </div>
    </form:form>
</div>
</body>
</html>
