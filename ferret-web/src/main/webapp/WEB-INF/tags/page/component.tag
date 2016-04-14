<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="component" type="com.iodesystems.ferret.web.models.Component" %>

<c:set var="component" scope="request" value="${component}"/>
<c:import url="/components/${component.type}.jsp"/>
