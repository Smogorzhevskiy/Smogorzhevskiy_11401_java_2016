<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 04.10.15
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String user = (String) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login.jsp");
        }
    %>
    <script type="application/javascript" src="js/jquery-2.1.4.min.js"></script>
    <title>Site</title>
    <link href="style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<form action="Registration" method="post">
<div id="wrapper">
    <div id="header">
        <div id="logo">
            <a href="index.jsp"></a>
        </div>
        <div id="menu">
            <ul>
                <li><input type="submit" name="profile" value="Profile"></li>
                <li><input type="submit" name="artists" value="Artist"></li>
                <li><input type="submit" name="logout" value="Logout"></li>
            </ul>
        </div>
    </div>
</div>
</form>
    <div id="content">
        <form>
            <input  type="text" id="s" oninput="f()"/>
            <select class="dropdown" id="y" oninput="f">
                <option value="users">user</option>
                <option value="artists">artist</option>
                <option value="picture">picture</option>
            </select>
            <div id ="res"></div>
        </form>
        <script type="application/javascript">
            f = function (request, response) {
                if  ($("#s").val().length >0)
                $.ajax({
                    url: "/FindServlet",
                    data: {"q": $("#s").val(), "types": $("#y").val()},
                    dataType: "json",
                    success: function (response_data) {
                        if (response_data.results.length != 0) {
                            $("#res").html("Search results:");
                            for (var i = 0; i < response_data.results.length; i++) {
                                $("#res").append("<li>" + response_data.results[i] + "</li>")
                            }
                        } else {
                            $("#res").html("No results");
                        }
                    }
                })
                else $("#res").text("")
            }
        </script>
        <h1></h1>
        <h2></h2>
        <p></p>
    </div>
    <div id="footer"></div>
</div>

</body>
</html>