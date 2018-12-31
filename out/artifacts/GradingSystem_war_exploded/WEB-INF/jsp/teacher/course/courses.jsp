<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/11/29
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Courses</title>
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
    <div id="table">
        <table class="table table-hover">
            <caption>Your have ${size} course(s)</caption>
            <thead>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Credit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${courses}" var="course">
                <tr>
                    <td>${course.code}</td>
                    <td>${course.name}</td>
                    <td>${course.credit}</td>
                    <td>
                        <a class="btn btn-default" role="button"
                           href="${pageContext.request.contextPath}/teacher/${course.code}/assignments">
                            Assignment</a>
                        <a class="btn btn-default" role="button"
                           href="${pageContext.request.contextPath}/teacher/${course.code}/assignment-sheet">
                            Add Assignment</a>
                        <a class="btn btn-default" role="button"
                           href="${pageContext.request.contextPath}/teacher/${course.code}/students">
                            Students</a>
                        <a class="btn btn-default" role="button"
                           href="${pageContext.request.contextPath}/teacher/${course.code}/students-not-in-course">
                            Add Students</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
