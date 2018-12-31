<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/5
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Students</title>
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
            <caption>There has ${size} student(s) who did not choose this course</caption>
            <thead>
            <tr>
                <th>Username</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.username}</td>
                    <td>
                        <a class="btn btn-default" role="button"
                           href="${pageContext.request.contextPath}/teacher/${code}/${student.uid}/add-student-to-course">
                            Add</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
