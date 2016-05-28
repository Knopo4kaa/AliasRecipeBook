<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: drowerik
  Date: 27.05.16
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <script src="/resources/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" >
    <link rel="stylesheet" href="/resources/style.css" >
    <title>Title</title>
</head>
<body>
<div class="container">

    <div class="col-md-12" style="margin-top: 15%">
        <div id="winners"  style="">
            <h2 style="text-align: center">Winner</h2>
            <div class="col-md-12">

                <div class="col-md-12">
                    <div class="col-md-4" style="height: 55px">
                        <h3>Team:</h3>
                    </div>
                    <div class="col-md-8">
                        <h3 class="team"  >${winner.title}</h3>
                    </div>
                </div>

                <div class="col-md-12">

                    <div class="col-md-9" style="height: 55px">
                        <h3>Score:</h3>
                    </div>
                    <div class="col-md-3">
                        <h3 class="score">${winner.score}</h3>
                    </div>

                </div>

                <div class="col-md-12">

                    <div class="col-md-9" style="height: 55px;">
                        <h3>Words guessed:</h3>
                    </div>
                    <div class="col-md-3" >
                        <h3 class="score">${winner.guessed}</h3>
                    </div>

                </div>
                <div class="col-md-12">

                    <div class="col-md-9" style="height: 55px;">
                        <h3>Words not guessed:</h3>
                    </div>
                    <div class="col-md-3" >
                        <h3 class="score">${winner.notGuessed}</h3>
                    </div>

                </div>
                <center><button type="submit" id="id" class="btn btn-default" style="margin-top: 10px" name="id" value="${winner.id}">Play again!</button></center>
            </div>
        </div>

    </div>
    <%@include file="footer.jsp"%>
</div>
</body>
<script>
    $(document).ready(function () {
        $("#id").click(function () {
            window.location="/teampage";
        });
    });
</script>
</html>
