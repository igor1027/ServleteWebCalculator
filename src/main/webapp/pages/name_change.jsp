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
<jsp:include page="_header.jsp"/>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
           <form action="${pageContext.request.contextPath}/change_username" method="post">
               <label>
                   <div class="mb-3">
                       <label for="exampleInputEmail1" class="form-label">Enter a new name</label>
                       <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                   </div>
               </label>
               <button type="submit" class="btn btn-primary">Submit</button>
           </form>
        </div>
    </div>
</div>
</body>
</html>
