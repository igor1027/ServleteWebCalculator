<%--
  Created by IntelliJ IDEA.
  User: Zenbook
  Date: 27.10.2021
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<%--<p>Hello ${sessionScops.user.name}</p>--%>
<a href="${pageContext.request.contextPath}/change_username">Change username</a>
<a href="${pageContext.request.contextPath}/change_password">Change password</a>
<a href="${pageContext.request.contextPath}/calc">Calculator</a>
<a href="${pageContext.request.contextPath}/deleted_account">Deleted account</a>
<a href="${pageContext.request.contextPath}/">Home</a>
</body>
</html>
