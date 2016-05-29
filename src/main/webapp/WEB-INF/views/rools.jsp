<%--
  Created by IntelliJ IDEA.
  User: drowerik
  Date: 28.05.16
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <script src="/resources/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="/resources/slider.js"></script>

    <link rel="stylesheet" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" >
    <link rel="stylesheet" href="/resources/style.css" >
    <link rel="stylesheet" href="/resources/slider.css" >
    <script type="text/javascript" src="/resources/slider/js/jssor.slider.mini.js"></script>
    <title>Title</title>
</head>
<body style="background-color: transparent">

<a href="/" style="font-size: 20px; text-decoration: none">< Home</a>

<div id="jssor_1" style="position: relative; margin: 0 auto; top: 10%; left: 0px; width: 600px; height: 300px; overflow: hidden; visibility: hidden;">
    <!-- Loading Screen -->
    <div data-u="loading" style="position: absolute; top: 0px; left: 0px;">
        <div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
        <div style="position:absolute;display:block;background:url('{% static 'shop/img/loading.gif' %}') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
    </div>
    <div data-u="slides" style="cursor: default; position: relative; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden;">
        <div data-p="112.50" style="display: none;">
            <img data-u="image" src="/resources/images/rool1.png" />

        </div>
        <div data-p="112.50" style="display: none;">
            <img data-u="image" src="/resources/images/rool2.png" />

        </div>
        <div data-p="112.50" style="display: none;">
            <img data-u="image" src="/resources/images/rool3.png" />

        </div>
        <a data-u="ad" href="http://www.jssor.com" style="display:none">jQuery Slider</a>

    </div>
    <!-- Bullet Navigator -->
    <div data-u="navigator" class="jssorb01" style="bottom:16px;right:16px;">
        <div data-u="prototype" style="width:12px;height:12px;"></div>
    </div>
    <!-- Arrow Navigator -->
    <span data-u="arrowleft" class="jssora02l" style="top:0px;left:8px;width:55px;height:55px;" data-autocenter="2"></span>
    <span data-u="arrowright" class="jssora02r" style="top:0px;right:8px;width:55px;height:55px;" data-autocenter="2"></span>
</div>



</body>
</html>
