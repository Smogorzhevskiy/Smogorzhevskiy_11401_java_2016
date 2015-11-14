<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<html>
<head>

    <title>Profile</title>
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
<%HttpSession s= request.getSession();%>
<h1><%=s.getAttribute("user")%></h1>
<img width="200" height="200" src=<%=request.getAttribute("avatar")%> >
<form name="Form" method=POST action=/Settings enctype="multipart/form-data">
    <input type=file name=FileName>
    <input type=submit value="Avatar" >
    </form>
<h2>Picture</h2>
<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("/login.jsp");
    } else{
%>
    <%Iterator itr;%>
    <% List data= (List)request.getAttribute("profile");
        for (itr=data.iterator(); itr.hasNext(); ) {

    %>
    <img src=<%=itr.next()%> >
    <%}}%>

</body>
</html>



