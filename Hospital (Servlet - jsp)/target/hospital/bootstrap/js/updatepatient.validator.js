$(document).ready(function () {
    $("#updatePatientValidator").validate({
        rules: {
            name: {
                required: true,
            },
            surname: {
                required: true,
            },
            phone: {
                required: true,
                digits: true,
            },
            address: {
                required: true,
            }
            ,
        },
        messages: {
            name: {
                required: "This field is required",
            }
            ,
            surname: {
                required: "This field is required",
            }
            ,
            phone: {
                required: "This field is required",
                digits: "Enter valid number. For example 380501234567"
            }
            ,
            address: {
                required: "This field is required",
            }
            ,
        }
    })
    ;
});