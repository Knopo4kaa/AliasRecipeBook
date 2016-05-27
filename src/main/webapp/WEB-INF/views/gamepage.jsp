<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <script src="/resources/jquery-1.11.3.js"></script>
    <link rel="stylesheet" href="/webjars/bootstrap/3.2.0/css/bootstrap.min.css" >
    <link rel="stylesheet" href="/resources/style.css" >
    <script type="text/javascript" src="/resources/timer/inc/TimeCircles.js"></script>
    <link rel="stylesheet" href="/resources/timer/inc/TimeCircles.css" />
    <link rel="stylesheet" href="/resources/reverse.css" />
    <title>Title</title>
</head>
<body>
<script>
    function show(state){

        document.getElementById('window').style.display = state;
        document.getElementById('wrap').style.display = state;
    }
</script>
<div class="container">


    <div class="col-md-12">
        <div class="col-md-4">
            <div class="col-md-12">
                <div class="col-md-4" style="height: 85px">
                    <div class="score" style="margin-top: 15%"></div>
                </div>
                <div class="col-md-8">
                    <h3 class="team"  >${team.title}</h3>
                </div>
            </div>
            <div class="col-md-12">
                <div class="col-md-4" style="height: 85px">
                    <div class="score"  style="margin-top: 15%"></div>
                </div>
                <div class="col-md-8">
                    <h3 class="score">0</h3>
                </div>
            </div>



        </div>
        <div class="col-md-4">
            <div class="timer" id="CountDownTimer" data-timer="${time}" style="width: 300px; height: 170px;"></div>
        </div>
        <div class="col-md-4"></div>

    </div>
    <div class="col-md-12">
        <div class="col-md-4">
            <div class="no">
            </div>
        </div>
        <div class="col-md-4">
            <div class="flip-container">
                <div class="flipper">
                    <div class="front startTimer">
                        <h3 class="title" style="color: whitesmoke">Click to start!</h3>
                    </div>
                    <div class="back">
                    <c:forEach items="${words}" var="word">
                        <h3 class="word" style="color: whitesmoke" hidden>${word.word}</h3>
                    </c:forEach>
                    </div>

                </div>
            </div>
        </div>
        <div id="wrap"></div>
        <div class="col-md-4" id="window">
            <h1 style="text-align: center">Time is over!</h1>
            <h1 style="text-align: center">Team:</h1>
            <h1 class="team" style="text-align: center">${team.title}</h1>
            <h1 style="text-align: center">Score:</h1>
            <h1 class="score" style="text-align: center"></h1>
            <form action="/game" method="post">
                <input type="text" name="score" class="input_score" hidden>
                <center><button type="submit" class="btn btn-default"  name="id" value="${team.id}">Next turn!</button></center>
            </form>
        </div>
        <div class="col-md-4">
            <div class="yes">
            </div>
        </div>
    </div>
        <%--<button class="btn btn-success startTimer">Start Timer</button>--%>
        <%--<button class="btn btn-danger stopTimer">Stop Timer</button>--%>

    <%@include file="footer.jsp"%>
</div>
</body>

<script>


    $(document).ready(function () {
        $( ".word" ).first().show();
        var words = document.getElementsByClassName(".word");
        var check;
        var score = 0;
        var gameStarted = 0;

        $(".flip-container").click(function () {
            $(".flip-container").addClass('flip');
            gameStarted = 1;
            check = setInterval(checkFunction, 1);
        });

        function checkFunction() {
            var currentTime =  $('#timer').text();
            if (currentTime == '0'){
                $("#CountDownTimer").TimeCircles().stop();
                $("h1.score").html(score);
                $(".input_score").val(score);
                show('block');
            }
        }

        function show(state){

            document.getElementById('window').style.display = state;
            document.getElementById('wrap').style.display = state;
        }

//        $('#wrap').click(function () {
////            show('none');
//            clearInterval(check);
//        });

        $(".yes").click(function () {
            if (gameStarted){
                $( ".word" ).first().remove();
                $( ".word" ).first().show();
                score++;
                $(".score").html(score);


            }

        });




        $(".no").click(function () {
            if (gameStarted){
                $( ".word" ).first().remove();
                $( ".word" ).first().show();
                score--;
                $(".score").html(score);
            }

        });





    });


    $("#CountDownTimer").TimeCircles({ time: { Days: { show: false }, Hours: { show: false }, Minutes: {show: false} }});
    $("#CountDownTimer").TimeCircles().start();
    $("#CountDownTimer").TimeCircles().stop();
    var updateTime = function(){
        var date = $("#date").val();
        var time = $("#time").val();
        var datetime = date + ' ' + time + ':00';
        $("#DateCountdown").data('date', datetime).TimeCircles().start();

    }


    $("#date").change(updateTime).keyup(updateTime);
    $("#time").change(updateTime).keyup(updateTime);

    // Start and stop are methods applied on the public TimeCircles instance
    $(".startTimer").click(function() {
        $("#CountDownTimer").TimeCircles().start();
    });
    $(".stopTimer").click(function() {
        $("#CountDownTimer").TimeCircles().stop();
    });

    // Fade in and fade out are examples of how chaining can be done with TimeCircles
    $(".fadeIn").click(function() {
        $("#PageOpenTimer").fadeIn();
    });
    $(".fadeOut").click(function() {
        $("#PageOpenTimer").fadeOut();
    });
</script>


</html>
