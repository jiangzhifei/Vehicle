<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="page-header">
    <h1>GPS供应商信息维护
        <small>查询与录入GPS供应商信息</small>
    </h1>
</div>
<div class="tabbable">
    <div class="row-fluid">
        <ul class="nav nav-tabs">
            <li class="active"><a href="#tab1" data-toggle="tab">GPS供应商信息</a></li>
            <li><a href="#tab2" data-toggle="tab">新增GPS供应商信息</a></li>
        </ul>
    </div>
    <div class="row-fluid">
        <div class="tab-content">
            <div class="tab-pane .fade active" id="tab1">
                <div class="row-fluid" style="margin: 1em 0em 1em 0em;">
                    <form id="vehicleInputForm" class="form-inline">
                        <div class="form-group">
                            <input type="text" class="form-control" id="venderName" placeholder="供应商名称" autofocus>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="vehicleNo" placeholder="供应商用户名">
                        </div>
                        <button type="submit" class="btn btn-default" id="gpsSearchBtn">检索</button>
                    </form>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>序号</th>
                            <th>供应商名称</th>
                            <th>服务URL</th>
                            <th>用户名</th>
                            <th>密码</th>
                            <td>操作</td>
                        </tr>
                        </thead>
                        <tbody>
                        <tr id="line1">
                            <td class="no">1</td>
                            <td class="name">易流</td>
                            <td class="url">http://test.test.com</td>
                            <td class="userName">test</td>
                            <td class="password">1111111</td>
                            <td><button class="btn btn-danger" data-toggle="modal" data-target="#myModal" data-source="line1">修改</button></td>
                        </tr>
                        <tr id="line2">
                            <td class="no">2</td>
                            <td class="name">英迪</td>
                            <td class="url">http://test.test.com</td>
                            <td class="userName">test</td>
                            <td class="password">1******1</td>
                            <td><button class="btn btn-danger" data-toggle="modal" data-target="#myModal" data-source="line2">修改</button></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="tab-pane .fade" id="tab2">
                <p>GPS供应商信息维护</p>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>--%>
                <h4 class="modal-title" id="myModalLabel">修改GPS供应商信息</h4>
            </div>
            <div class="modal-body">
                <form id="gpsEdit">
                    <div class="form-group">
                        <label for="gpsVender">GPS供应商名称(*)</label>
                        <input type="text" class="form-control" id="gpsVender" placeholder="GPS供应商名称" required autofocus>
                    </div>
                    <div class="form-group">
                        <label for="url">GPS供应商服务url(*)</label>
                        <input type="text" class="form-control" id="url" placeholder="GPS供应商服务url" required>
                    </div>
                    <div class="form-group">
                        <label for="userName">GPS供应商服务用户名(*)</label>
                        <input type="text" class="form-control" id="userName" placeholder="GPS供应商服务用户名" required>
                    </div>
                    <div class="form-group">
                        <label for="pwd">GPS供应商服务密码(*)</label>
                        <input type="text" class="form-control" id="pwd" placeholder="GPS供应商服务密码" required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $("#myModal").on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var recipient = button.data('source') ;

        $("#gpsVender").val($('#'+recipient+' .name').text());
        $("#userName").val($('#'+recipient+' .userName').text());
        $("#url").val($('#'+recipient+' .url').text());
        $("#pwd").val($('#'+recipient+' .password').text());

    });
</script>