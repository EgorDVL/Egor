$(document).ready(function () {
    $("#newAccountForm").validate({
        rules: {
            cardId: {
                required: true,
                digits: true,
                min: 8
            },
            name: {
                required: true,
            },
        },
        messages: {
            cardId: {
                required: "This field is required",
                digits: "Enter valid number",
                min: "Max values  "
            },
            name: {
                required: "This field is required",
            },
        }
    });
});