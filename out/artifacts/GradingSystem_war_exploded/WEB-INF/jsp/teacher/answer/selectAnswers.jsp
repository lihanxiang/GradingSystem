<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/9
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Choose Answers</title>
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

    <form action="${pageContext.request.contextPath}/teacher/${code}/${aid}/get-answers-by-both">
        <h4>Get Answer By Title And Student Name</h4>
        <div class="form-group">
            <label for="Question">Question:</label>
            <select class="form-control" id="Question" name="title">
                <c:forEach items="${questions}" var="question">
                    <option value="${question.title}">${question.title}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="Student">Student:</label>
            <select class="form-control" id="Student" name="username">
                <c:forEach items="${students}" var="username">
                    <option value="${username}">${username}</option>
                </c:forEach>
            </select>
        </div>
        <input type="submit" value="Submit">
    </form><br>

    <form action="${pageContext.request.contextPath}/teacher/${code}/${aid}/get-answers-by-title">
        <h4>Get Answers List By Title</h4>
        <div class="form-group">
            <label for="onlyQuestion">Question:</label>
            <select class="form-control" id="onlyQuestion" name="title">
                <c:forEach items="${questions}" var="question">
                    <option value="${question.title}">${question.title}</option>
                </c:forEach>
            </select>
        </div>
        <input type="submit" value="Submit">
    </form><br>

    <form action="${pageContext.request.contextPath}/teacher/${code}/${aid}/get-answers-by-username">
        <h4>Get Answers List By Student Name</h4>
        <div class="form-group">
            <label for="onlyStudent">Student:</label>
            <select class="form-control" id="onlyStudent" name="username">
                <c:forEach items="${students}" var="username">
                    <option value="${username}">${username}</option>
                </c:forEach>
            </select>
        </div>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
