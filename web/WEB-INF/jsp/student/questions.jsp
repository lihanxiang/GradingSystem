<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/11/30
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Question List</title>
    <c:import url="head.jsp"/>
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
            <caption>Question List</caption>
            <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Weight</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${questions}" var="question">
                <tr>
                    <td>${question.title}</td>
                    <td>${question.description}</td>
                    <td>${question.weight}</td>
                    <td>
                        <a class="btn btn-default" role="button"
                            href="${pageContext.request.contextPath}/student/${question.qid}/answer-sheet">
                            Answer</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
