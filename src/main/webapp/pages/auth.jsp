<%--
  Created by IntelliJ IDEA.
  User: Zenbook
  Date: 26.10.2021
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
           <form action="${pageContext.request.contextPath}/authorization" method="post">
              <div class="mb-3">
                 <label for="exampleInputEmail1" class="form-label">Username</label>
                 <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
               </div>
              <div class="mb-3">
                 <label for="exampleInputPassword1" class="form-label">Password</label>
                 <input type="password" name="password" class="form-control" id="exampleInputPassword1">
              </div>
                 <button type="submit" class="btn btn-primary">Submit</button>
           </form>
            <c:if test="${requestScope.message != null}">
                <div class="alert alert-warning d-flex align-items-center" role="alert">
                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Warning:"><use xlink:href="#exclamation-triangle-fill"/></svg>
                    <div>
                        ${requestScope.message}
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
