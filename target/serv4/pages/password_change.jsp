<%--
  Created by IntelliJ IDEA.
  User: Zenbook
  Date: 27.10.2021
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/change_password" method="post">
    <label>
        <input type="password" name="password" placeholder="Password">
    </label>
    <button>Submit</button>
</form>
</body>
</html>
