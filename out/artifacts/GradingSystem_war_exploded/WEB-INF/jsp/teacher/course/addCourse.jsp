<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/5
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Course Info</title>
    <c:import url="../head.jsp"/>
</head>
<body>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/teacher/main">Back to Main Page</a>
            </div>
        </div>
    </nav>
    <form style="margin-left: 35%;margin-right: 35%" action="${pageContext.request.contextPath}/teacher/add-course" method="post">
        <h3 style="text-align: center">Add Course</h3>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Course Code" name="code">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Course Name" name="name">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Course Credit" name="credit">
        </div>
        <button type="submit" class="btn btn-primary mb-2">Post</button>
    </form>
</body>
</html>
