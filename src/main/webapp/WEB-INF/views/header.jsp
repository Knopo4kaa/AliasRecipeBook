<%--
  Created by IntelliJ IDEA.
  User: drowerik3
  Date: 04.05.17
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <a class="navbar-brand" href="/">Recipe Book</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">All Recipes<span class="sr-only">(current)</span></a></li>
                <li><a href="/newrecipe">Add New Recipe</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Categories <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${categories}" var="category">
                            <li><a href="/category/${category.id}">${category.category}</a></li>
                        </c:forEach>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left" action="/search" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="title" placeholder="Search by ingredient">
                </div>
                <button type="submit" class="btn btn-default">Search</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/myrecipes">My recipes</a></li>
                <li><a href="/signout">Sign out</a></li>
                <%--<li class="dropdown">--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<li><a href="#">Action</a></li>--%>
                        <%--<li><a href="#">Another action</a></li>--%>
                        <%--<li><a href="#">Something else here</a></li>--%>
                        <%--<li role="separator" class="divider"></li>--%>
                        <%--<li><a href="#">Separated link</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
