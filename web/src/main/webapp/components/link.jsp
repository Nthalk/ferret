<jsp:useBean id="component"
             type="com.iodesystems.ferret.web.models.components.Link"
             scope="request"/>
<a href="${component.href}">${component.text}</a>
