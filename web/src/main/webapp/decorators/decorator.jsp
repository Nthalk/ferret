<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <title><sitemesh:write property='title'/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/font-awesome/4.6.3/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/toastr/2.1.2/build/toastr.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/c3/0.4.11/c3.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loader.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/site.css"/>

    <script src="${pageContext.request.contextPath}/webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/d3js/3.5.5/d3.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/c3/0.4.11/c3.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/vue/1.0.24/vue.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/toastr/2.1.2/build/toastr.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/ajaxy.forms.js"></script>
    <script src="${pageContext.request.contextPath}/js/integration/bootstrap.modal.fix.js"></script>

    <sitemesh:write property='head'/>
</head>
<body>

<%-- Notifications --%>
<c:if test="${not empty notifications}">
    <jsp:useBean id="notifications" scope="session" type="java.util.List<com.iodesystems.ferret.web.models.Notification>"/>
    <c:forEach var="notification" items="${notifications}">
        <script>
            toastr["${notification.type}"]("${notification.message}");
        </script>
    </c:forEach>
    <%session.removeAttribute("notifications");%>
</c:if>

<%-- Nav Bar --%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${spring:mvcUrl("home").build()}">Ferret</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#"
                       class="dropdown-toggle"
                       data-toggle="dropdown"
                       role="button"
                       aria-haspopup="true"
                       aria-expanded="false">
                        Settings
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/data-sources"/>">Data Sources</a></li>
                        <li><a href="#">Schemas</a></li>
                        <li><a href="#">Entities</a></li>
                        <li><a href="#">Views</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Users</a></li>
                        <li><a href="#">Profile</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div id="main">
    <sitemesh:write property="body"/>
</div>

</body>
</html>
