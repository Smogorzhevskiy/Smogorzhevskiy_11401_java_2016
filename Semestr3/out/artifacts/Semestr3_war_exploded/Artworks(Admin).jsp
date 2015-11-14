<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <%
        String user = (String) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login.jsp");
        }
    %>
    <title>SO question 4112686</title>
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
<%Iterator itr;%>
<% List data= (List)request.getAttribute("list");
    for (itr=data.iterator(); itr.hasNext(); ) {

%>
<form action="/View_Picture" method="post">
    <img src=<%=itr.next()%> >
<%Object id=itr.next();%>
    <input type="submit" value="add"   class="btt"  /><input type="hidden" name="id" value=<%=id%>  />

    <%System.out.println(id);%>
</form>

<form action="/View_Picture" method="post" ><input type="submit" value="delete"   name="delete"  /><input type="hidden" name="iddel" value=<%=id%>  /></form>

<%}%>

</body>
</html>
