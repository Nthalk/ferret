<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fer" tagdir="/WEB-INF/tags/fer" %>
<%@ taglib prefix="url" tagdir="/WEB-INF/tags/url" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="tableShow" scope="request" type="com.iodesystems.ferret.web.controllers.models.TableShow"/>

<html>
<head>
    <title>Table: ${tableShow.table.name}</title>
</head>
<body>

<div class="container">
    <h1>${tableShow.table.name}</h1>
    <h3>Fields</h3>
</div>
</body>
</html>
