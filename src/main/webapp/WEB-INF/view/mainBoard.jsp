<%--
  Created by IntelliJ IDEA.
  User: jiang
  Date: 15/7/29
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="/commonCss.jsp" %>
<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>上海富鹰物流定位信息系统</title>

</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">上海富鹰</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <%--<li><a href="#">Dashboard</a></li>--%>
                <%--<li><a href="#">Settings</a></li>--%>
                <li><a href="">${userName}</a></li>
                <li><a href="${ctx}/manage/logout.htm">退出</a></li>
            </ul>
            <%--<form class="navbar-form navbar-right">--%>
            <%--<input type="text" class="form-control" placeholder="Search...">--%>
            <%--</form>--%>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active" onclick="onCommand('gpsList.htm')"><a href="#">GPS供应商信息维护 <span class="sr-only">(current)</span></a></li>
                <%--<li><a href="#">Reports</a></li>--%>
                <%--<li><a href="#">Analytics</a></li>--%>
                <%--<li><a href="#">Export</a></li>--%>
            </ul>

            <ul class="nav nav-sidebar" role="navigation">
                <li class="dropdown">
                    <a id="drop" href="#" role="button" class="dropdown-toggle" data-toggle="dropdown" >车辆、挂车管理
                        <b class="caret"></b></a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                        <li onclick="onCommand('vehicleInput.htm')"><a tabindex="-1" href="#">信息录入</a></li>
                        <li><a tabindex="-1" href="#">车辆查询</a></li>
                        <li><a tabindex="-1" href="#">车辆信息修改</a></li>
                        <li><a tabindex="-1" href="#">车辆激活</a></li>
                        <%--<li class="divider"></li>--%>
                        <%--<li><a tabindex="-1" href="#">Separated link</a></li>--%>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="mainContent">
        </div>
    </div>
</div>
<%@include file="/commonJs.jsp" %>
<script src="/statics/js/mainBoard.js?version=0.0.1"/>
<script src="/statics/js/ie-emulation-modes-warning.js?version=0.0.1"></script>
<script src="/statics/js/ie-emulation-modes-warning.js?version=0.0.1"></script>
</body>
</html>
