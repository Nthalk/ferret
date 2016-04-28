<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:useBean id="component"
             type="com.iodesystems.ferret.web.models.components.Form"
             scope="request"/>

<form:form method="post">
    <c:forEach items="${component.components}" var="child">
        <page:component component="${child}"/>
    </c:forEach>
</form:form>
