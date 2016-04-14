<!doctype html>
<html>
<head>
    <title><sitemesh:write property='title'/></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <script src="${pageContext.request.contextPath}/webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/vue/1.0.20/vue.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.6/css/bootstrap.css"/>


    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sidebar.css"/>
    <sitemesh:write property='head'/>
</head>
<body>
<sitemesh:write property="body"/>
</body>
</html>
