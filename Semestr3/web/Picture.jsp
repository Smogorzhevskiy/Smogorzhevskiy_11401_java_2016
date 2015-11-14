<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.11.15
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*"%>
<html>
<head>
    <%
        String user = (String) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login.jsp");
        }
    %>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251" />
    <script type="application/javascript" src="js/jquery-2.1.4.min.js"></script>
    <script type="application/javascript">
        $(document).ready(function(){
            $('#btt').click(function(){
                var id = $('#path').val();
                $.ajax({
                    type:'POST',
                    url:'/AddPicture',
                    data:{id:id},
                    success: function(result){
                        $('#res').html(result);
                    }
                });
            });
        });
        /* f = function (request) {

         $.ajax({
         url: "/AddPicture",
         data: {"q": $(".s").val()},
         dataType: "json",
         success: function (response_data) {
         json(".s").trigger("reset");
         $("#res").html("Search results:");

         }
         });
         }*/
    </script>
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
<%=request.getAttribute("picture")%> by <%=request.getAttribute("artist")%>
<%String path=(String)request.getAttribute("path");%>
<img  src=<%=path%>>
<form>
    <input type="button" value="Add"   id="btt"  /><input type="hidden" id="path" value=<%=path%>  />

    <span id ="res"></span>
</form>
<table border="1" width="303">
    <%Iterator itr;%>
    <% List data= (List)request.getAttribute("comments");
        for (itr=data.iterator(); itr.hasNext(); ) {
%>

            <tr>
            <td width="100"><img width="100" height="100" src=<%=itr.next()%> >
                <%=itr.next()%></td>
            <td width="1000"><%=itr.next()%> <input type="hidden" value="<%=itr.next()%>"></td>
        </tr>
    <%}%>
</table>
<form action="/Add_Comments" method="post">
    <p><b>Comment:</b></p>
    <p><textarea name="text" rows="10" cols="45"></textarea> <input type="hidden" name="id" value=<%=request.getAttribute("id")%>></p>
    <p><input type="submit" value="add"></p>
</form>
</body>
</html>
