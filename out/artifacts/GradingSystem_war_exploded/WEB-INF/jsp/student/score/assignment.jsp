<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/15
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Assignment Score</title>
    <c:import url="../head.jsp"/>
</head>
<body>
<div id="table">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/student/main">Back to Main Page</a>
            </div>
        </div>
    </nav>
    <table class="table table-hover">
        <caption>Your score of this assignment is ${score}</caption>
        <thead>
        <tr>
            <th>Question Title</th>
            <th>Question Weight</th>
            <th>Your Score</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sets}" var="question">
            <tr>
                <td>${question.title}</td>
                <td>${question.weight}</td>
                <td>${question.score}</td>
                <td>
                    <a class="btn btn-default" role="button"
                       href="${pageContext.request.contextPath}/student/${question.qid}/answer-sheet">
                        Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
