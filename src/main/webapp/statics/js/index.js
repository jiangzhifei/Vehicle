/**
 * Created by jiang on 15/7/29.
 */
$(document).ready(function() {
    $('#loginForm').formValidation({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userName: {
                validators: {
                    notEmpty: {
                        message: '请输入用户名'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '请输入密码'
                    }
                }
            }
        }
    });
});

$('#myButton').on('click', function () {
    $(this).attr('disabled', 'disabled');
    var form = $("#loginForm");
    $.ajax({
        type: "POST",
        async : false,
        url: form.attr('action'),
        data: form.serialize(),
        dataType: 'json'
    })
        .complete(function (data) {
            if ('0' == data.responseText) {
                $("#myAlert").css('display', 'none');
                setTimeout(function(){window.location.href="/manage/mainBoard.htm"},0);
            }
            else{
                $("#myAlert").css('display', 'block');
                $("#alet").html(data.responseText);
            }
        })
    ;
    $(this).removeAttr('disabled');

    return false;
})