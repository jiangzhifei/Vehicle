<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="page-header">
    <h1>车辆录入</h1>
</div>
<form id="vehicleInputForm">
    <div class="form-group">
        <label for="vehicleNo">车牌(*)</label>
        <input type="text" class="form-control" id="vehicleNo" placeholder="车牌" required autofocus>
    </div>
    <div class="form-group">
        <label for="vehicleType">类型(*)</label>
        <select class="form-control"  id="vehicleType" >
            <option>车辆</option>
            <option>挂车</option>
            <option>箱柜</option>
        </select>
    </div>
    <div class="form-group">
        <label for="exampleInputFile">选择文件</label>
        <input type="file" id="exampleInputFile">
        <p class="help-block">请选择批量导入文件</p>
    </div>
    <button type="submit" class="btn btn-default" id="vehicleInputSubmit" onclick="vehicleSubmit()">确定</button>
</form>
<%--<script src="/statics/js/mainBoard.js"/>--%>
<script type="text/javascript">
    $(document).ready(function () {
        $('#vehicleInputForm').formValidation({
            framework: 'bootstrap',
            icon: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                vehicleNo: {
                    validators: {
                        notEmpty: {
                            message: '请输入车辆编号'
                        }
                    }
                },
                vehicleType: {
                    validators: {
                        notEmpty: {
                            message: '请选择车辆类型'
                        }
                    }
                }
            }
        });
    });
</script>