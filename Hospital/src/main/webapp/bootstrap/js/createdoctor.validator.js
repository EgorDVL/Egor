$(document).ready(function () {
    $("#createDoctorValidator").validate({
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
            specialty: {
                required: true,
            },
            experience: {
                required: true,
                digits: true,
                min: 1
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
                digits: "Enter valid number. For example 380501234567"
            },
            dateOfBirth: {
                required: "This field is required",
                date: "Please enter your date of birth"
            },
            specialty: {
                required: "This field is required",
            },
            experience: {
                required: "This field is required",
                digits: "Enter valid number",
                min: "Use values greater than 0"
            },
        }
    });
});