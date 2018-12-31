<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/4
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Question Info</title>
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

    <form class="form-signin" style="margin-left: 35%;margin-right: 35%"
          action="${pageContext.request.contextPath}/teacher/${code}/${aid}/add-question" method="post">
        <h2 class="form-signin-heading" style="text-align: center">Add Questions</h2><br>
        <input type="text" name="aid" class="form-control" placeholder="Assignment ID: ${aid}"
               value="${aid}" readonly><br>
        <textarea name="title" class="form-control" placeholder="Title"
                  required></textarea><br>
        <textarea name="description" class="form-control" placeholder="Description"
                  required></textarea><br>
        <input type="text" name="weight" class="form-control" placeholder="Weight"
               required><br>
        <button class="btn btn-lg btn-primary" type="submit">Create</button>
    </form>
</body>
</html>
