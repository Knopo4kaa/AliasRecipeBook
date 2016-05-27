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
        <div id="results">
            <c:forEach items="${t}" var="team">
                <div class="col-md-12">
                    <div class="col-md-4" style="height: 85px">
                        <div class="score" style="margin-top: 15%"></div>
                    </div>
                    <div class="col-md-8">
                        <h3 class="team"  >${t.title}</h3>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="col-md-4" style="height: 85px">
                        <div class="score"  style="margin-top: 15%"></div>
                    </div>
                    <div class="col-md-8">
                        <h3 class="score">${t.score}</h3>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <%@include file="footer.jsp"%>
</div>
</body>
</html>
