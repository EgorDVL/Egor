$(document).ready(function () {
    $("#updateSymptomValidate").validate({
        rules: {
            symptoms: {
                required: true,
            },
        },
        messages: {
            symptoms: {
                required: "This field is required",
            },

        }
    });
});