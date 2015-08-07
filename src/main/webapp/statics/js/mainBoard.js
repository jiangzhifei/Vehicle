/**
 * Created by jiang on 15/7/31.
 */
function onCommand(action) {
    $.ajax({
        type: "get",
        async: true,
        url: '/manage/' + action
    }).complete(function (data) {
        $("#mainContent").html(data.responseText);
    });
}

function vehicleSubmit(){
    var form = $("#vehicleInputForm");
    var formValidation = $(form).data('formValidation');
    $(form)
        //.formValidation('updateStatus', 'birthday', 'NOT_VALIDATED')
        .formValidation('validateField', 'vehicleNo')
        .formValidation('validateField', 'vehicleType');
}
$("#vehicleInputSubmit").on('click', function (){
    $(this).attr('disabled', 'disabled');
    var form = $("#vehicleInputForm");

});

$("#myModal").on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget);
    var recipient = button.data('source') ;


});