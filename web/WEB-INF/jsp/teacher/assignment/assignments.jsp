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
    <title>Assignments</title>
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
            <caption>In this course, there has ${size} assignment(s)</caption>
            <thead>
            <tr>
                <th>Name</th>
                <th>Question Number</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${assignments}" var="assignment">
                <tr>
                    <td>${assignment.name}</td>
                    <td>${assignment.questionNum}</td>
                    <td>
                        <a class="btn btn-default" role="button"
                           href="${pageContext.request.contextPath}/teacher/${code}/${assignment.aid}/questions">
                            Questions</a>
                        <a class="btn btn-default" role="button"
                           href="${pageContext.request.contextPath}/teacher/${code}/${assignment.aid}/question-sheet">
                            Add Question</a>
                        <a class="btn btn-default" role="button"
                           href="${pageContext.request.contextPath}/teacher/${code}/${assignment.aid}/select-answers">
                            Check Answers</a>
                        <a class="btn btn-default" role="button"
                           href="${pageContext.request.contextPath}/teacher/${code}/${assignment.aid}/select-student">
                            Write Summary</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
