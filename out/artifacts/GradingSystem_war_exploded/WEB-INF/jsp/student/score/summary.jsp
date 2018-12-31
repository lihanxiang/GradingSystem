<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/12/16
  Time: 9:12
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
                <a class="navbar-brand" href="${pageContext.request.contextPath}/student/main">Back to Main Page</a>
            </div>
        </div>
    </nav>
    <form>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Assignment ID: ${summary.aid}" readonly>
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Student ID: ${summary.uid}" readonly>
        </div>
        <div class="form-group">
            <textarea class="form-control" cols="30" rows="5" placeholder="${summary.evaluation}" required></textarea>
        </div>
    </form>
</body>
</html>

