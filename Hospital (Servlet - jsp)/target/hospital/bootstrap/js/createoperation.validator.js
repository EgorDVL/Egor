$(document).ready(function () {
    $("#createOperationValidator").validate({
        rules: {
            name: {
                required: true,
            },
            date: {
                required: true,
            },
        },
        messages: {
            name: {
                required: "This field is required",
            },
            date: {
                required: "This field is required",
            },
        }
    });
});