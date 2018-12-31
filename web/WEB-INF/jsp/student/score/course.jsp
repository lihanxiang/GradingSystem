<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/15
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Course Grade Point</title>
    <c:import url="../head.jsp"/>
</head>
<body>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/student/main">Back to Main Page</a>
            </div>
        </div>
    </nav>
    <div id="table">
        <table class="table table-hover">
            <caption>Your grade point of this course is ${grade}</caption>
            <thead>
            <tr>
                <th>Course Code</th>
                <th>Assignment Title</th>
                <th>Your Score</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sets}" var="assignment">
                <tr>
                    <td>${assignment.code}</td>
                    <td>${assignment.name}</td>
                    <td>${assignment.score}</td>
                    <td>
                        <a class="btn btn-default" role="button"
                           href="${pageContext.request.contextPath}/student/${assignment.aid}/assignment-score">
                            Detail</a>
                        <a class="btn btn-default" role="button"
                           href="${pageContext.request.contextPath}/student/${assignment.aid}/summary">
                            Summary</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
