$(document).ready(function () {
    $("#newPaymentForm").validate({
        rules: {
            accountId: {
                required: true,
            },
            destinationId: {
                required: true,
                digits: true,
                min: 1
            },
            amount: {
                required: true,
                number: true,
                min: 0.1
            },
        },
        messages: {
            accountId: {
                required: "This field is required",
            },
            destinationId: {
                required: "This field is required",
                digits: "Enter valid number",
                min: "Use values greater than 0",
            },
            amount: {
                required: "This field is required",
                number: "Enter valid number",
                min: "Use values greater than 0",
            },
        }
    });
});