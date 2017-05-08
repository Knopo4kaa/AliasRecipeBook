<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <script src="/resources/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" >
    <link rel="stylesheet" href="/resources/style.css" >
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Alias</title>
</head>
<body>


<%@include file="header.jsp"%>
<div class="container">
    <div class="jumbotron col-md-12">
        <c:forEach items="${recipes}" var="recipe">

            <div class="recipeItem col-md-4">
                    <c:forEach items="${recipe.images}" var="image" varStatus="loop">
                        <c:choose>
                            <c:when test="${loop.index==0}">
                                <img src="${image.url}"/>
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <h3 ><a href="/recipe/${recipe.id}">${recipe.title}</a></h3>
                    <div style="display: flex; justify-content: space-around">
                        <span>${recipe.time} minutes</span>
                        <span>${recipe.count} servings</span>
                    </div>
                    <br>
                <span><b>Author:</b><a class="unlink" href="/recipes/${recipe.user.id}">${recipe.user.name} ${recipe.user.surname}</a> </span>
                </div>
        </c:forEach>
    </div>
</div>

</body>


</html>