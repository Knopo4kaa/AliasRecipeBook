<%--
  Created by IntelliJ IDEA.
  User: drowerik
  Date: 23.05.16
  Time: 23:50
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
    <div class="col-md-12" style="margin-top: 4%">
        <div class="col-md-5"></div>
        <div class="col-md-3 remove">
        </div>
        <div class="col-md-4"></div>
    </div>

    <div class="teams">

        <div class="col-md-12" style="margin-top: 1%">
            <div class="col-md-4"></div>
            <div class="col-md-3 menu">
                <input type="text" class="team" name="title" value="Lolsuka" readonly>
                <div class="buttons"></div>
            </div>
            <div class="col-md-5"></div>
        </div>
        <div class="col-md-12" style="margin-top: 1%">
            <div class="col-md-4"></div>
            <div class="col-md-3 menu">
                <input type="text" class="team" name="title" readonly>
                <div class="buttons">
                </div>
            </div>
            <div class="col-md-5"></div>
        </div>
    </div>
    <div class="col-md-12" style="margin-top: 1%">
        <div class="col-md-5"></div>
        <div class="col-md-3 plus">
        </div>
        <div class="col-md-4"></div>
    </div>

    <%@include file="footer.jsp"%>
</div>
</body>
<script>

    $(document).ready(function () {

        var count = 2;

        $(".col-md-3.plus").click(function () {
            if (count < 5){
                $('.teams').append('<div class="col-md-12" style="margin-top: 1%"> \
                    <div class="col-md-4"></div> \
                    <div class="col-md-3 menu"> \
                     <input type="text" class="team" name="title" readonly> \
                    <div class="buttons"> \
                    </div> \
                    </div> \
                    <div class="col-md-5"></div> \
                    </div>');
                count++;
            }
            else{
                alert("Only 5 teams can play!");
            }

        });

        $('.col-md-3.remove').click(function () {
            if (count > 2){
                $(".col-md-12:last-child").remove();
                count--;
            }
        });
    });



</script>
</html>
