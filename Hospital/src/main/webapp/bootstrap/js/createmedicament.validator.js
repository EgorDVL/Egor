$(document).ready(function () {
    $("#createMedicamentValidator").validate({
        rules: {
            name: {
                required: true,
            },
            use: {
                required: true,
            },
            dateStart: {
                required: true,
            },
            dateEnd: {
                required: true,
            },
        },
        messages: {
            name: {
                required: "This field is required",
            },
            use: {
                required: "This field is required",
            },
            dateStart: {
                required: "This field is required",
            },
            dateEnd: {
                required: "This field is required",
            },
        }
    });
});