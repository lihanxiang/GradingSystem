<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/16
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Courses Grade Point</title>
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
        <caption>Your GPA is ${gpa}</caption>
        <thead class="thead-dark">
        <tr>
            <th>Course Code</th>
            <th>Course Name</th>
            <th>Course Credit</th>
            <th>Your Grade</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sets}" var="course">
            <tr>
                <td>${course.code}</td>
                <td>${course.name}</td>
                <td>${course.credit}</td>
                <td>${course.grade}</td>
                <td>
                    <a class="btn btn-default" role="button"
                       href="${pageContext.request.contextPath}/student/${course.code}/course-grade-point">
                        Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
