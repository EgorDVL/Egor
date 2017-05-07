$(document).ready(function () {
    $("#createAppointmentValidator").validate({
        rules: {
            name: {
                required: true,
            },
        },
        messages: {
            name: {
                required: "This field is required",
            },
        }
    });
});