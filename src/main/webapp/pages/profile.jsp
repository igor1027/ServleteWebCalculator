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
<jsp:include page="_header.jsp"/>
<c:if test="${sessionScope.user != null}">
    <ul class="nav nav-tabs navbar-dark " style="background-color: #363636;">
        <li class="nav-item">
            <a class="nav-link" aria-current="page" href="/change_username">Change username</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/change_password">Change password</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/calc">Calculator</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/deleted_account">Deleted account</a>
        </li>
    </ul>
</c:if>
<%--<a href="${pageContext.request.contextPath}/change_username">Change username</a>--%>
<%--<a href="${pageContext.request.contextPath}/change_password">Change password</a>--%>
<%--<a href="${pageContext.request.contextPath}/calc">Calculator</a>--%>
<%--<a href="${pageContext.request.contextPath}/deleted_account">Deleted account</a>--%>
</body>
</html>
