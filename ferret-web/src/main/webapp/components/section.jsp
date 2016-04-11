<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>

<jsp:useBean id="component"
             type="com.iodesystems.ferret.web.models.components.Section"
             scope="request"/>

<div class="section">
    <h2>
        ${component.title}
        <c:if test="${not empty component.subTitle}">
            <small>${component.subTitle}</small>
        </c:if>
    </h2>

    <c:forEach items="${component.components}" var="component">
        <page:component component="${component}"/>
    </c:forEach>
</div>
