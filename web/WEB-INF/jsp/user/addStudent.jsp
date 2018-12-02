<%--
  Created by IntelliJ IDEA.
  User: 94545
  Date: 2018/11/27
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create Account</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <style>
        body{
            background-color: #CDCDC1;
        }
        .col-center-block {
            float: none;
            display: block;
            margin-top: 20%;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<div class="container">
    <div class="row myCenter">
        <div class="col-xs-6 col-md-4 col-center-block">
            <form class="form-signin" action="${pageContext.request.contextPath}/user/add-student" method="post">
                <h2 class="form-signin-heading" style="text-align: center">Create Account</h2><br>
                <p class="form-signin-heading" style="text-align: center">${message}</p>
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="username" class="form-control" placeholder="Username"
                       required value="${user.username}"><br>
                <label for="password" class="sr-only">Password</label>
                <input type="password" id="password" name="password" class="form-control" placeholder="Password"
                       required value="${user.password}"><br>
                <label for="realname" class="sr-only">Real Name</label>
                <input type="text" id="realname" name="realname" class="form-control" placeholder="Real Name"
                       required value="${user.realname}"><br>
                <label for="phone" class="sr-only">Phone</label>
                <input type="text" id="phone" name="phone" class="form-control" placeholder="Phone"
                       required value="${user.phone}"><br>
                <label for="email" class="sr-only">Email</label>
                <input type="text" id="email" name="email" class="form-control" placeholder="Email"
                       required value="${user.email}"><br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
