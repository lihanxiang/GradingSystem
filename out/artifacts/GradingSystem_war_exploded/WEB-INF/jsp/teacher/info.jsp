<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/25
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <c:import url="head.jsp"/>
</head>
<body>
    <form action="${pageContext.request.contextPath}/teacher/update-info" method="post">
        <h3 style="text-align: center">User Info</h3>
        <div class="form-group">
            Username <input type="text" class="form-control" name="username" value="${user.username}">
        </div>
        <div class="form-group">
            Real Name <input type="text" class="form-control" name="realname" value="${user.realname}">
        </div>
        <div class="form-group">
            Phone <input type="text" class="form-control" name="phone" value="${user.phone}">
        </div>
        <div class="form-group">
            Email <input type="text" class="form-control" name="email" value="${user.email}">
        </div>
        <button type="submit" class="btn btn-primary mb-2">Post</button>
    </form>
</body>
</html>
