<%--
  Created by IntelliJ IDEA.
  User: drowerik
  Date: 25.05.16
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
    <link rel="stylesheet" href="/resources/range.css" >
    <title>Title</title>
</head>

<body>
<div class="container">
    <form action="/game" method="post">
    <div class="options"></div>
    <div class="col-md-12" style="margin-top: 15%">
        <div class="col-md-3"></div>
        <div class="col-md-1">
            <h2>Time:</h2>
            <h2>Level:</h2>
        </div>

            <div class="col-md-4">
                <div class="range range-danger"  style="width: 350px; margin-top: 8%">
                    <input type="range" name="time" min="2" max="60" value="30" onchange="rangeDanger.value=value">
                    <output id="rangeDanger">30</output>

                </div>
                <div class="col-md-12">
                    <div class="col-md-2">
                        <div style=" margin-top: 20px">
                            <input type="radio" name="level" value="1" style="width: 30px; height: 30px" checked>
                        </div>
                        <br>
                        <div>
                            <input type="radio" name="level" value="2" style="width: 30px; height: 30px">
                        </div>
                        <br>
                        <div>
                            <input type="radio" name="level" value="3" style="width: 30px; height: 30px">
                        </div>
                    </div>
                    <div class="col-md-10">
                        <h3 style=" margin-top: 25px">Easy</h3>
                        <h3 style=" margin-top: 30px">Medium</h3>
                        <h3 style=" margin-top: 30px">High</h3>
                    </div>
                </div>
            </div>


        <div class="col-md-4">

        </div>
    </div>
        <button type="submit" class="next"></button>
    </form>

    <%@include file="footer.jsp"%>
</div>
</body>
<style>
    h2,h3{
        font-family: Comic Sans, Comic Sans MS, cursive;
    }
</style>
</html>
