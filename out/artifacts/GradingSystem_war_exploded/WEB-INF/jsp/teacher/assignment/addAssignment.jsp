<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/11/29
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Assignment Info</title>
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
    <form style="margin-left: 35%;margin-right: 35%" class="form-signin" action="${pageContext.request.contextPath}/teacher/${code}/add-assignment" method="post">
        <h2 class="form-signin-heading" style="text-align: center">Add Assignment</h2><br>
        <h4 style="text-align: center">You are adding assignment for ${code}</h4>
        <input type="text" name="code" class="form-control" placeholder="Code" value="${code}" readonly><br>
        <input type="text" name="name" class="form-control" placeholder="Name" required><br>
        <input type="text" name="questionNum" class="form-control"
               placeholder="Number of Questions" required><br>
        <input type="date" name="deadline" class="form-control" value="2018-12-31"
               placeholder="Deadline" required><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Add</button>
    </form>
</body>
</html>
