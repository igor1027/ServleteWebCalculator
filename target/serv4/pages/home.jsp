
<%--
  Created by IntelliJ IDEA.
  User: Zenbook
  Date: 26.10.2021
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Index</title>
</head>
<body>
<p>
    <c:if test="${sessionScope.user == null}">
        <a href="${pageContext.request.contextPath}/registration">Registration</a>
        <a href="${pageContext.request.contextPath}/authorization">Authorization</a>
    </c:if>

    <c:if test="${sessionScope.user != null}">
        <a href="${pageContext.request.contextPath}/profile">Profile</a>
        <a href="${pageContext.request.contextPath}/logout">LogOut</a>
    </c:if>

</p>
</body>
</html>
