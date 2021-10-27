<%--
  Created by IntelliJ IDEA.
  User: Zenbook
  Date: 26.10.2021
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/authorization" method="post">
    <label>
        <input type="text" name="username" placeholder="Username">
    </label>
    <label>
        <input type="password" name="password" placeholder="Password">
    </label>
    <button>Submit</button>
</form>
</body>
</html>
