<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*, java.io.*"%>
<html>
<head>
    <%

        String user = (String) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login.jsp");
        }
    %>
    <title>Данные из БД</title>
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
<table border="1" width="303">
    <tr>
        <td width="119"><b>Name</b></td>
        <td width="168"><b>Picture</b></td>
    </tr>
    <%Iterator itr;%>
    <% List data= (List)request.getAttribute("data");
        for (itr=data.iterator(); itr.hasNext(); ) {

    %>
    <form action="/AuthorServlet" method="post">
    <tr>
        <td width="119"><input type="submit" value= "<%=itr.next()%>"><input type="hidden" value= "<%=itr.next()%>" name= "id"  ></td>
        <td width="168"><img src=<%=itr.next()%> ></td>
    </tr>
   </form>
    <%}%>
</table>
</body>
</html>