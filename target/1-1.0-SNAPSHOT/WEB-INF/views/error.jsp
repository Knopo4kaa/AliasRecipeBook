<%--
  Created by IntelliJ IDEA.
  User: drowerik
  Date: 27.05.16
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <script src="/resources/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" >
    <link rel="stylesheet" href="/resources/style.css" >
    <title>Alias</title>
</head>
<body>
<script>
    $(document).ready(function () {
        $('#oops').click(function () {
            window.location.replace("/");
        });
    });
</script>
<div class="container">
    <div class="" id="oops" style="cursor: pointer;"></div>
    <br>
    <h2 style="text-align: center">Error occurred :( ${exception}</h2>
    <br>
    <h2 style="text-align: center">Url : ${url}</h2>
</div>

</body>
</html>
