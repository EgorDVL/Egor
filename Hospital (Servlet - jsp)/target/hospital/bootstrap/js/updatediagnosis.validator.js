$(document).ready(function () {
    $("#updateDiagnosisValidate").validate({
        rules: {
            diagnosis: {
                required: true,
            },
        },
        messages: {
            diagnosis: {
                required: "This field is required",
            },
        }
    });
});