<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
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
<%
    if (session.getAttribute("user") == null) response.sendRedirect("/login.jsp");
    if(!session.getAttribute("user").equals("Allan")) response.sendRedirect("/index.jsp");
%>
<br>
<h1>Add Picture</h1>
<form action="/AddWorks" method=POST enctype="multipart/form-data">
    Picture: <input input type=file name=FileName><br>
    Name: <input type="text" name="picture_name" size="10"><br>

    <input type="submit" name="login" value="Add"><input type="hidden" value="<%=request.getAttribute("id_author")%>" name="id_author">
    <%System.out.println(request.getAttribute("id_author"));%>


</form>
<br>
</body>
</html>
