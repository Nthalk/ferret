<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="component"
             type="com.iodesystems.ferret.web.models.components.form.Label"
             scope="request"/>

<label class="control-label">
    ${component.text}
    ${component.required ? '*' :''}
</label>
