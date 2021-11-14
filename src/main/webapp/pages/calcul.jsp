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
<jsp:include page="_header.jsp"/>
    <ul class="nav nav-tabs navbar-dark " style="background-color: #363636;">
        <li class="nav-item">
            <a class="nav-link" aria-current="page" href="/profile">Back</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" aria-current="page" href="/">Home</a>
        </li>
    </ul>
<form action="${pageContext.request.contextPath}/calc" method="post">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-10">
                <p>
                   <div class="col-sm-3" >
                      <label class="visually-hidden" for="specificSizeInputName1">Number 1</label>
                      <input type="number" name="num1" class="form-control" id="specificSizeInputName1"
                              placeholder="Number" >
                   </div>
                   <div class="col-sm-3">
                      <select name="operation" class="form-select form-select-sm" aria-label=".form-select-sm example">
                          <option disabled selected>Open this select menu</option>
                          <option value="sum">+</option>
                          <option value="sub">-</option>
                          <option value="mul">*</option>
                          <option value="div">/</option>
                      </select>
                   </div>
                   <div class="col-sm-3">
                      <label class="visually-hidden" for="specificSizeInputName2">Number 2</label>
                      <input type="number" name="num2" class="form-control" id="specificSizeInputName2"
                             placeholder="Number">
                   </div>
<%--        <input type="submit" value="result">--%>
                  <button type="submit" class="btn btn-outline-dark" value="result">Result</button>
                </p>
                <p>
                   <ul>
                      <ol class="list-group list-group-numbered">
                        <c:forEach var="operation" items="${requestScope.listOperation}">
                        <li><c:out value="${operation}"/> </li>
                        </c:forEach>
                      </ol>
                   </ul>
                </p>
            </div>
        </div>
    </div>
</form>
</body>
</html>
