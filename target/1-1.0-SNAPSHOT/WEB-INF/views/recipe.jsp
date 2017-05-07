<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <script src="/resources/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" >
    <link rel="stylesheet" href="/resources/style.css" >
    <link rel="stylesheet" href="/resources/font-awesome/css/font-awesome.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Alias</title>
</head>
<body>


<%@include file="header.jsp"%>
<div class="container">
    <div class="jumbotron col-md-12">
        <div style="text-align: center">
            <span class="circle"></span><span style="color: crimson; font-size: 18px">&nbsp${recipe.category.category}</span><span class="circle"></span>
        </div>
        <div style="text-align: center">
            <h1>${recipe.title}</h1>
        </div>
        <div style="text-align: center">
            <i class="fa fa-cutlery"  style="font-size: 18px;"></i>
            <span style="font-size: 18px;font-weight: bold">${recipe.count} portions&nbsp&nbsp&nbsp&nbsp</span>
            <span class="glyphicon glyphicon-time" style="font-size: 18px;"></span>
            <span style="font-size: 18px;font-weight: bold">${recipe.time} minutes</span>
        </div>
        <%--<div style="display: flex;justify-content: center">--%>

            <%--<div style="text-align: center; word-wrap: break-word; width: 300px;margin-top: 20px;">--%>
                <%--<h4>Description</h4>--%>
                <%--<span style="font-size: 17px">${recipe.description}</span>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div style="display: flex; justify-content: flex-start ">
            <div id="myCarousel" style="margin-top: 15px;" class="carousel slide" data-ride="carousel"><!-- Wrapper for slides -->
            <div class="carousel-inner">
                <c:forEach items="${recipe.images}" var="image" varStatus="loop">
                    <c:choose>

                        <c:when test="${loop.index==0}">
                            <div class="item active">
                                <img src="${image.url}" alt="Los Angeles" style="height: 500px !important;width: 600px;">
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="item">
                                <img src="${image.url}" alt="Los Angeles" style="height: 500px !important;width: 600px;">
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
            <div style="margin-left: 30px; width: 100%">
                <div style="word-wrap: break-word; width: 100%;margin-top: 20px;">
                    <h4 style="font-weight: bold">Description</h4>
                    <span style="font-size: 17px">${recipe.description}</span>
                </div>
                <h4 style="font-weight: bold">Ingredients</h4>
                <div>
                    <c:forEach items="${recipe.ingredients}" var="ing">
                        <div style="display: flex; align-items: center">
                            <div><span>${ing.title}</span></div>
                            <div class="line"></div>
                            <div><span>${ing.count}</span></div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div style="display: flex;justify-content: center">

            <div style="text-align: center; word-wrap: break-word; width: 300px;margin-top: 20px;">
                <h4 style="font-weight: bold">Author</h4>
                <span style="font-size: 17px">${recipe.author}</span>
            </div>
        </div>
    </div>
</div>

</body>


</html>