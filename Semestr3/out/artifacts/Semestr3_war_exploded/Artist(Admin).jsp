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
Object name=itr.next();
            Object id=itr.next();
    %>

        <tr>
            <form action="/AuthorServlet" method="post">
            <td width="119"><input type="submit" value=<%=name%> name="name"><input type="hidden" value= "<%=id%>" name= "id"  ></td>
            <td width="168"><img src=<%=itr.next()%> ></td>
            <td width="100"><input type="submit" value= "delete" name="delete"><input type="hidden" value= "<%=name%>" name= "name"  ></td>
            <td width="100"><input type="submit" value= "Add_picture" name="add"><input type="hidden" value= "<%=id%>" name= "add_picture"  ></td>
    </form>

        </tr>

    <%}%>
</table>

<form action="AddArtist.jsp" method="post">
     <input type="submit" value= "Add" name="add">
    </form>

</body>
</html>
