<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07.04.16
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div>
        <c:url value="/j_spring_security_check" var = "loginUrl" />
        <form action = "${loginUser}" method = "post">
            <h2>Pleas sign in</h2>
            <input type="text" name="j_username" placeholder="Email">
            <input type="password" name="j_password" placeholder="Password">
            <button type="submit">Login </button>
        </form>
        
    </div>
</body>
</html>
