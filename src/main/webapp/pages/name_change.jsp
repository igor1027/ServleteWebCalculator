<%--
  Created by IntelliJ IDEA.
  User: Zenbook
  Date: 27.10.2021
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Name</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/change_username" method="post">
    <label>
        <input type="text" name="name" placeholder="Name">
    </label>
    <button>Submit</button>
</form>
</body>
</html>
