$(document).ready(function () {
    $("#createPatientValidator").validate({
        rules: {
            name: {
                required: true,
            },
            surname: {
                required: true,
            },
            phone: {
                required: true,
                digits: true
            },
            dateOfBirth: {
                required: true,
                date: true
            },
            address: {
                required: true,
            },
        },
        messages: {
            name: {
                required: "This field is required",
            },
            surname: {
                required: "This field is required",
            },
            phone: {
                required: "This field is required",
                digits: "Enter valid number.  For example 380501234567"
            },
            dateOfBirth: {
                required: "This field is required",
                date: "Please enter your date of birth"
            },
            address: {
                required: "This field is required",
            },
        }
    });
});