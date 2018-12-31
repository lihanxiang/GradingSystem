<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/4
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Answer Sheet</title>
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
    <form action="${pageContext.request.contextPath}/student/${qid}/post-answer" method="post">
        <div class="form-group">
            <label for="title">Question Title</label>
            <input type="text" id="title" class="form-control" placeholder="${title}" readonly>
        </div>
        <div class="form-group">
            <label for="answer">Your Answer</label>
            <textarea class="form-control" id="answer" cols="30" rows="5"
                      name="answer" required>${answer.answer}</textarea>
        </div>
        <button type="submit" class="btn btn-primary mb-2">Post</button>
    </form>
</body>
</html>
