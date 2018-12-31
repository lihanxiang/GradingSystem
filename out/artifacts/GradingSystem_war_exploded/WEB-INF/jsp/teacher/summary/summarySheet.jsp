<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/14
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Summary Sheet</title>
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
    <form action="${pageContext.request.contextPath}/teacher/${code}/${aid}/${uid}/write-summary" method="post">
        <div class="form-group">
            <input type="text" class="form-control" name="aid" value="${aid}" readonly>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="uid" value="${uid}" readonly>
        </div>
        <div class="form-group">
            <label for="evaluation">Evaluation</label>
            <textarea class="form-control" id="evaluation" cols="30" rows="5"
                      name="evaluation" required></textarea>
        </div>
        <button type="submit" class="btn btn-primary mb-2">Post</button>
    </form>
</body>
</html>
