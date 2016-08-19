<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="dataSourceCreate" scope="request" type="com.iodesystems.ferret.web.controllers.models.DataSourceCreate"/>

<form:form modelAttribute="dataSourceCreate"
           method="post"
           id="dataSourceCreateForm"
           cssClass="form-horizontal">

    <div class="modal-header">
        <h4 class="modal-title">Create new DataSource</h4>
    </div>

    <div class="modal-body">
        <form:hidden path="dataSource.id"/>
        <spring:bind path="dataSource.name">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:label class="col-lg-2 control-label"
                            path="dataSource.name">
                    Name
                </form:label>
                <div class="col-lg-6">
                    <form:input path="dataSource.name"
                                class="form-control"
                                placeholder="DataSource Name"/>
                    <form:errors path="dataSource.name"
                                 cssClass="help-block"/>
                </div>
            </div>
        </spring:bind>
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
    </div>
    <div class="modal-footer text-right">
        <a class="btn btn-default" data-dismiss="modal">Back</a>
        <button type="submit" class="btn btn-success">Add DataSource</button>
    </div>
    <script>
        $(function () {
            $("#dataSourceCreateForm").ajaxyForms();
        });
    </script>
</form:form>

