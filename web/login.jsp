<%--
  Created by IntelliJ IDEA.
  User: ange
  Date: 2018/5/15
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="gb2312"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>login</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <link rel="stylesheet" type="text/css" href="font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="bootstrap-4.1.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/login_style.css">
    <script src="bootstrap-4.1.1-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid header">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-3">
            <img src="image/web-logo.png" alt="">
        </div>
    </div>
</div>

<div class="container login-form">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <form action="login" class="" method="post">
                <div class="form-group">
                    <label for="username">user name</label>
                    <input type="text" class="form-control" id="username" placeholder="enter your name" name="username"/>
                </div>
                <div class="form-group">
                    <label for="password">user password</label>
                    <input type="password" class="form-control" id="userpwd" placeholder="enter your password" name="userpwd"/>
                </div>
                <div class="form-check">
                    <label for="" class="form-check-label"><input type="checkbox" class="form-check-input"/>remember me</label>
                </div>
                <div class="row re-btn">
                    <div class="col-md-2">
                        <a href="register.jsp" class="btn btn-warning btn-2x">×¢²á</a>
                    </div>
                    <div class="col-md-10">
                        <input type="submit" class="btn btn-danger btn-2x" value="µÇÂ½"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>