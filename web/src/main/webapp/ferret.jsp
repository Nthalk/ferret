<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="ferret" scope="request" type="com.iodesystems.ferret.xsd.Ferret"/>
<html>
<head>
    <title>Ferret</title>
</head>
<body>
Ferret!
${ferret.data.jdbc.driver}
</body>
</html>
