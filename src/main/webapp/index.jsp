<%@include file="commonCss.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
    <title>富鹰物流定位信息系统</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/statics/style/signin.css" rel="stylesheet"/>

</head>

<body>

<div class="container">

    <form class="form-signin" action="/api/login.htm" id="loginForm" method="post" data-toggle="validator">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="userName" class="sr-only">用户名</label>
        <div class="form-group">
        <input type="userName" name="userName" id="userName" class="form-control" placeholder="输入用户名" required autofocus>
        </div>
        <label for="inputPassword"  class="sr-only">密码</label>
        <div class="form-group">
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="输入密码" required >
        </div>
        <button class="btn btn-lg btn-primary btn-block " id="myButton" type="submit">登录</button>
        <div id="myAlert" class="alert alert-warning" style="display: none">
            <a href="#" class="close" data-dismiss="alert">&times;</a>
            <strong>登陆失败！</strong><span id="alet">结果是成功的。</span>
        </div>
    </form>

</div>

<%@include file="commonJs.jsp"%>
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="/statics/js/ie-emulation-modes-warning.js"></script><![endif]-->
<script src="/statics/js/ie-emulation-modes-warning.js?version=0.0.1"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<![endif]-->
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/statics/js/ie10-viewport-bug-workaround.js?version=0.0.1"></script>
<script src="/statics/js/index.js"></script>

</body>
</html>
