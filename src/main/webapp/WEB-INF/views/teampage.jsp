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
    <form action="/options" method="post">
    <div class="teams">

    </div>
    <div class="col-md-12" style="margin-top: 1%">
        <div class="col-md-5"></div>
        <div class="col-md-3 plus">
        </div>
        <div class="col-md-4"></div>
    </div>

        <button type="submit">Next step</button>
    </form>
    <%@include file="footer.jsp"%>
</div>
</body>
<script>
    var usedNames = [];
    var names = ["Блестящие", "Пиу-пиу", "Дичь", "Что попало", "Акулы Бизнеса",
        "Животные","Бешеные псы","Однокнопочные","Злобные хорьки","Настольные монстры"];

    function generateRandomName() {
        var randomNumber = 0;
        var _name;

        randomNumber = Math.floor((Math.random() * names.length));
        _name = names[randomNumber];
        usedNames.push(_name);
        names.splice(randomNumber,1);
        return _name;
    }
    
    
    $(document).ready(function () {
        var count = 0;
        var _name;
        for (var i = 0; i < 2; i++){
            _name = generateRandomName();
            $('.teams').append('<div class="col-md-12" style="margin-top: 1%"> \
                    <div class="col-md-4"></div> \
                    <div class="col-md-3 menu"> \
                     <input type="text" class="team" name="title[]" readonly> \
                    <div class="buttons"> \
                    </div> \
                    </div> \
                    <div class="col-md-5"></div> \
                    </div>');
            $( ".team" ).last().val(_name);
            $( ".team" ).last().attr("id", count);
            $( ".buttons" ).last().attr("id", count);
            count++;
        }



        $(".col-md-3.plus").click(function () {
            if (count < 5){
                var _name;
                _name = generateRandomName();
                $('.teams').append('<div class="col-md-12" style="margin-top: 1%"> \
                    <div class="col-md-4"></div> \
                    <div class="col-md-3 menu"> \
                     <input type="text" class="team" name="title[]" readonly> \
                    <div class="buttons"> \
                    </div> \
                    </div> \
                    <div class="col-md-5"></div> \
                    </div>');
                $( ".team" ).last().val(_name);
                $( ".team" ).last().attr("id", count);
                $( ".buttons" ).last().attr("id", count);
                count++;

            }
            else{
                alert("Only 5 teams can play!");
            }

        });

        $('.col-md-3.remove').click(function () {
            if (count > 2){
                var _name = $( ".team" ).last().val();
                $(".col-md-12:last-child").remove();
                names.push(_name);
                usedNames.splice(usedNames.length-1,1);
                count--;
            }
        });

        setInterval(function () {
            $(".buttons").click(function () {
                if (names.length != 0){
                    var current = $(this).attr("id");
                    var teams = document.getElementsByClassName('team');
                    var newNname = generateRandomName()
                    var oldName = teams[current].value;
                    var a = usedNames.indexOf(oldName);
                    names.push(oldName);
                    usedNames.splice(a,1);
                    teams[current].value = newNname;
                }

            });
        },0.1);


    });



</script>
</html>
