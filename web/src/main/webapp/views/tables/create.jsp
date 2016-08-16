<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="tableCreate" scope="request" type="com.iodesystems.ferret.web.controllers.models.TableCreate"/>
<html>
<head>
    <title>Create Table</title>
</head>
<body>
<div class="container">
    <form:form modelAttribute="tableCreate">
        <fieldset>
            <form:input path="table.name"/>

        </fieldset>
    </form:form>
</div>
</body>
</html>

