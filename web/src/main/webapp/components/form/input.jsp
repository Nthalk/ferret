<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="component"
             type="com.iodesystems.ferret.web.models.components.Input"
             scope="request"/>

<div>
    <label class="control-label">
        ${component.label}
        ${component.required ? '*' :''}
    </label>

    <input class="form-control"
           type="${component.type}"
           placeholder="${component.placeholder}"/>
</div>
