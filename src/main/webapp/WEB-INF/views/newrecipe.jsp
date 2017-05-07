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
<script>
    $(function() {
        // Remove button click
        $(document).on(
            'click',
            '[data-role="dynamic-fields"] > .form-inline [data-role="remove"]',
            function(e) {
                e.preventDefault();
                $(this).closest('.form-inline').remove();
            }
        );
        // Add button click
        $(document).on(
            'click',
            '[data-role="dynamic-fields"] > .form-inline [data-role="add"]',
            function(e) {
                e.preventDefault();
                var container = $(this).closest('[data-role="dynamic-fields"]');
                new_field_group = container.children().filter('.form-inline:first-child').clone();
                new_field_group.find('input').each(function(){
                    $(this).val('');
                });
                container.append(new_field_group);
            }
        );
    });
</script>

<script>

</script>

<%@include file="header.jsp"%>
<div class="container">
    <div class="jumbotron" style="display: flex; justify-content: center">
        <div style="text-align: center; width: 50%">
            <form action="/createrecipe" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="title">Recipe title:</label>
                    <input type="text" required class="form-control" id="title" placeholder="Enter recipe name" name="title">
                </div>
                <div class="form-group">
                    <label for="desc">Description:</label>
                    <textarea class="form-control" required rows="5" id="desc" name="description" placeholder="Enter some instructions"></textarea>
                </div>
                <div class="form-group">
                    <label for="portCount">Count of portions:</label>
                    <input type="number" min="1" max="20" required class="form-control" id="portCount" name="portCount" placeholder="Enter count of portions"/>
                </div>
                <div class="form-group">
                    <label for="time">Time of cooking:</label>
                    <input type="number" required min="1" max="600" class="form-control" id="time" name="time" placeholder="Enter time of cooking in minutes"/>
                </div>
                <div class="form-group">
                    <label for="category">Select category:</label>
                    <select class="form-control" id="category" name="category">
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.id}">${category.category}</option>
                        </c:forEach>
                    </select>
                </div>
                <label>Enter ingredients:</label>
                <div data-role="dynamic-fields">
                    <div class="form-inline">
                        <div class="form-group">
                            <label class="sr-only" for="field-name">Ingredient title</label>
                            <input type="text" required class="form-control" name="ingname[]" id="field-name" placeholder="Enter ingredient title">
                        </div>
                        <span>-</span>
                        <div class="form-group">
                            <label class="sr-only" for="field-value">Count</label>
                            <input type="text" required class="form-control" name="ingval[]" id="field-value" placeholder="Count (i.e. 150 grams)">
                        </div>
                        <button class="btn btn-danger" data-role="remove">
                            <span class="glyphicon glyphicon-remove"></span>
                        </button>
                        <button class="btn btn-primary" data-role="add">
                            <span class="glyphicon glyphicon-plus"></span>
                        </button>
                    </div>  <!-- /div.form-inline -->
                </div>
                <br>
                <br>
                <div class="form-group">
                    <label for="images">Select images</label>
                    <input style="margin-left: 20%" required type="file" class="btn btn-default btn-file" id="images" name="images" multiple />
                </div>
                <div class="form-group">
                    <label for="author">Author:</label>
                    <input type="text" class="form-control" required id="author" placeholder="Enter author's name and surname" name="author">
                </div>
                <button type="submit" class="btn btn-default" id="submit-btn">Submit</button>
            </form>
        </div>
    </div>
</div>

</body>


</html>