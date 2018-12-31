<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/11
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Answers</title>
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
        <caption>Under your selection, there has ${size} student(s)</caption>
        <thead>
        <tr>
            <th>Student Username</th>
            <th>Question Title</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${answers}" var="answer">
            <tr>
                <td>${answer.username}</td>
                <td>${answer.title}</td>
                <td>
                    <a class="btn btn-default" role="button"
                       href="${pageContext.request.contextPath}/teacher/${code}/${aid}/${answer.anid}/detail">
                        Detail</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
