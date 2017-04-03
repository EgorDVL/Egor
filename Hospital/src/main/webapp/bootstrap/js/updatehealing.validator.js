$(document).ready(function () {
    $("#updateHealingValidate").validate({
        rules: {
            dateEnd: {
                required: true,
            },
        },
        messages: {
            dateEnd: {
                required: "This field is required",
            },

        }
    });
});