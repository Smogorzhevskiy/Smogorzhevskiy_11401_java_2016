<%@ page import="java.io.PrintWriter" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18.10.15
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Форма входа в систему</title>
</head>
<body>
<%
    if (session.getAttribute("user") != null) response.sendRedirect("/index.jsp");
%>
<br>
<h1>Вход в систему</h1>
<form action="Registration" method="post">
    Пользователь: <input type="text" name="user" size="10"><br>
    Пароль: <input type="password" name="password" size="10"><br>
    <p>
    <table>
        <tr>
            <th><small>
                <input type="submit" name="login" value="Войти в систему">
            </small>
            <th><small>
                <input type="submit" name="registration" value="Зарегистрироваться">
            </small>
            <th><small><input type = 'checkbox' name = 'remember' id = 'remember' value = 'remember me'>
                <label for = 'remember'>Remember me</label></small>


    </table>

</form>
<br>
</body>
</html>
