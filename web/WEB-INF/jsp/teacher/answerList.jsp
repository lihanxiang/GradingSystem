<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/11/30
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Main</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <style>
        #table {
            margin-left: 20%;
            margin-right: 20%;
        }
        tr {
            font-family: "Gill Sans, sans-serif", serif;
            font-size: large;
        }
    </style>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Grading System</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Course
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Add Assignment</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Student
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Add Student</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Check Student Info</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="table">
    <table class="table table-hover">
        <caption>Course List</caption>
        <thead>
        <tr>
            <th>Question ID</th>
            <th>Answer</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${answerList}" var="answer">
            <tr>
                <td>${answer.qid}</td>
                <td>${answer.answer}</td>
                <td>
                    <button type="button" class="btn btn-primary">
                        Answer
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
