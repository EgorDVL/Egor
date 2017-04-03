$(document).ready(function () {
    $("#createHealingValidator").validate({
        rules: {
            dateStart: {
                required: true,
            },
            dateEnd: {
                required: true,
            },
        },
        messages: {
            dateStart: {
                required: "This field is required",
            },
            dateEnd: {
                required: "This field is required",
            },
        }
    });
});