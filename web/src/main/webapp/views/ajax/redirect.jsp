<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="ajaxRedirect" scope="request" type="com.iodesystems.ferret.web.controllers.models.AjaxRedirect"/>
<form>
    <script>
        document.location = "<c:url value="${ajaxRedirect.url}"/>";
    </script>
</form>
