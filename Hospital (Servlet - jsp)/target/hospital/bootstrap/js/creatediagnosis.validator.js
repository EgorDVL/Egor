$(document).ready(function () {
    $("#createDiagnosisValidator").validate({
        rules: {
            symptoms: {
                required: true,
            },
            diagnosis: {
                required: true,
            },
        },
        messages: {
            symptoms: {
                required: "This field is required",
            },
            diagnosis: {
                required: "This field is required",
            },
        }
    });
});