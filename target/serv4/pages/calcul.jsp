<%--
  Created by IntelliJ IDEA.
  User: Zenbook
  Date: 27.10.2021
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/calc" method="post">
    <p><input type="number" size="3" name="num1" value="number 1">
    <select name="operation" required>
        <option value="sum">+</option>
        <option value="sub">-</option>
        <option value="mul">*</option>
        <option value="div">/</option>
    </select>
        <input type="number" size="3" name="num2" value="number 2">
        <input type="submit" value="result">
    </p>
    <p>
        <ul>
           <c:forEach var="operation" items="${listOperation}">
              <li><c:out value="${operation}" /></li>
           </c:forEach>
        </ul>
    </p>
</form>
</body>
</html>
