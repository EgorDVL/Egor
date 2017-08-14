export default class DepartmentCreateUpdateForm {
    constructor() {
    };

    static showDepartmentCreateUpdateForm(depController, department) {

        $('#app').text('');

        let form = $('<form id="myForm">');
        form.addClass("container");

        let inputDepartmentId = $('<input>').attr('name', 'id').attr('id', 'idDep').attr('type', 'hidden')
            .attr('value', (department ? department.id : ''));

        let labelName = $('<label>').attr('class', 'label-employee-name').attr('for', 'name').text('Name');

        let inputName = $('<input>').attr('name', 'name').attr('id', 'nameDep').attr('type', 'text')
            .attr('value', (department ? department.name : ''));

        let createDepartmentButton = $('<button>')
            .attr('class', 'button-create-department')
            .attr("type", "submit")
            .text("Save")
            .on("submit", (event) => {
                event.preventDefault();
            });

        form.append(inputDepartmentId);
        form.append(labelName);
        form.append($('<br>'));
        form.append(inputName).append($('<div id="errMess"></div>').hide().slideDown());
        form.append($('<br>'));
        form.append(createDepartmentButton);

        $('#app').append(form);

        this.validDepartmentForm(depController);
    }


    static validDepartmentForm(depController) {
        $.validator.addMethod(
            "regex",
            (value, element, regexp) => regexp.test(value)
        );

        $("#myForm").validate({
            rules: {
                name: {
                    required: true,
                    minlength: 3,
                    maxlength: 16,
                    regex: /^[a-zA-Z]+$/
                }
            },
            messages: {
                name: {
                    required: "Please enter a name",
                    minlength: "Your name must min 3 characters",
                    minlength: "Your name must max 16 characters",
                    regex: "Input only letters"
                }
            },
            submitHandler: (event) => depController.createOrUpdateDepartment(event)
        });
    }
}
