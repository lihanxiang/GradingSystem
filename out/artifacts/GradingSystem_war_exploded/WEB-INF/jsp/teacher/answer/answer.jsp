<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/9
  Time: 16:32
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
    <form class="form-signin" action="${pageContext.request.contextPath}/teacher/${code}/${aid}/${answer.anid}/mark">
        <div class="form-group">
            <label for="QuestionID">Question ID:</label>
            <input class="form-control" id="QuestionID" type="text" value="${answer.qid}" readonly>
        </div>
        <div class="form-group">
            <label for="StudentID">Student ID:</label>
            <input class="form-control" id="StudentID" type="text" value="${answer.uid}" readonly>
        </div>
        <div class="form-group">
            <label for="Answer">Answer:</label>
            <textarea class="form-control" id="Answer" placeholder="${answer.answer}" readonly></textarea>
        </div>
        <div class="form-group">
            <label for="Score">Score: ( This Question's Weight is ${weight} )</label>
            <input class="form-control" type="number" id="Score" name="score"
                   value="${answer.score}"/>
        </div>
        <div class="form-group">
            <label for="Evaluation">Evaluation:</label>
            <textarea class="form-control" id="Evaluation"
                      placeholder="${answer.evaluation}" name="evaluation"></textarea>
        </div>
        <button class="btn btn-lg btn-primary" type="submit">Mark</button>
    </form>
</body>
</html>
