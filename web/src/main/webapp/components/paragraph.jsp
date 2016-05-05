<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags/page" %>
<jsp:useBean id="component"
             type="com.iodesystems.ferret.web.models.Paragraph"
             scope="request"/>
<p>
    ${component.text}
</p>