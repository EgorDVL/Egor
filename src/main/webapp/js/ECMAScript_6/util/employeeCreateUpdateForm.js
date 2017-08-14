export default class EmployeeCreateUpdateForm {
    constructor() {
    };

    static showEmployeeCreateOrUpdateForm(employeeController, departmentList, employee) {

        $('#app').text('');

        let form = $('<form id="myFormEmpl">');

        form.addClass("container");

        let labelName = $('<label>').attr('class', 'label-employee-name').text('Name');
        let labelSurname = $('<label>').attr('class', 'label-employee-surname').text('Surname');
        let labelExperience = $('<label>').attr('class', 'label-employee-experience').text('Experience');
        let labelEmail = $('<label>').attr('class', 'label-employee-email').text('Email');
        let labelDateOfBirth = $('<label>').attr('class', 'label-employee-dateofBirth').text('Date of Birth');
        let labelDepartment = $('<label>').attr('class', 'label-employee-department').text('Department');

        let inputEmployeeId = $('<input>').attr('name', 'id').attr('id', 'idEmpl').attr('type', 'hidden')
            .attr('value', (employee ? employee.id : ''));
        let inputName = $('<input>').attr('name', 'name').attr('id', 'nameEmpl').attr('type', 'text')
            .attr('value', (employee ? employee.name : ''));
        let inputSurname = $('<input>').attr('name', 'surname').attr('id', 'surnameEmpl').attr('type', 'text')
            .attr('value', (employee ? employee.surname : ''));
        let inputExperience = $('<input>').attr('name', 'experience').attr('id', 'experienceEmpl').attr('type', 'number')
            .attr('value', (employee ? employee.experience : 0));
        let inputEmail = $('<input>').attr('name', 'email').attr('id', 'emailEmpl').attr('type', 'email')
            .attr('value', (employee ? employee.email : ''));
        let inputDateOfBirth = $('<input>').attr('name', 'dateOfBirth').attr('id', 'dateOfBirthEmpl').attr('type', 'date')
            .attr('style', 'width: 173px;').attr('value', (employee ? employee.dateOfBirth : ''));

        let createEmployeeButton = $('<button>')
            .attr('class', 'button-create-department')
            .attr('type', 'submit')
            .text('Save')
            .on('submit', (event) => {
                event.preventDefault();
            });

        form.append(inputEmployeeId);
        form.append(labelName).append($('<br>')).append(inputName).append($('<br>'));
        form.append(labelSurname).append($('<br>')).append(inputSurname).append($('<br>'));
        form.append(labelExperience).append($('<br>')).append(inputExperience).append($('<br>'));
        form.append(labelEmail).append($('<br>')).append(inputEmail).append($('<div id="errMessEmployee"></div>'));
        form.append(labelDateOfBirth).append($('<br>')).append(inputDateOfBirth).append($('<br>'));
        form.append(labelDepartment).append($('<br>'));

        let select = $('<select>').attr('class', 'input-create-employee').attr('id', 'departmentIdEmpl')
            .attr('style', 'width: 173px;').attr('required', 'true');

        if (employee && employee.department) {
            let optionDepartment = $('<option>').attr('value', employee.department.id).attr('selected', 'true')
                .text(employee.department.name);
            select.append(optionDepartment);
        }
        $.each(departmentList, function (index, dep) {
            let options = $('<option>').attr('value', dep.id).text(dep.name);
            select.append(options);
        });

        form.append(select).append($('<br>'));
        form.append(createEmployeeButton);

        $('#app').append(form);

        this.validEmployeeForm(employeeController);
    }

    static validEmployeeForm(employeeController) {

        $.validator.addMethod(
            "regex",
            (value, element, regexp) => regexp.test(value)
        );

        $.validator.addMethod(
            "greaterThan",
            (value, element, params) => new Date(value) < new Date());

        $("#myFormEmpl").validate({
            rules: {
                name: {
                    required: true,
                    minlength: 3,
                    maxlength: 16,
                    regex: /^[a-zA-Z]+$/
                }
                ,
                surname: {
                    required: true,
                    minlength: 3,
                    maxlength: 16,
                    regex: /^[a-zA-Z]+$/
                }
                ,
                experience: {
                    required: true,
                    number: true,
                    min: 0,
                    max: 20,
                    regex: /^[0-9]+$/
                }
                ,
                email: {
                    required: true,
                    email: true,
                    minlength: 5,
                    maxlength: 30
                }
                ,
                dateOfBirth: {
                    required: true,
                    date: true,
                    greaterThan: true
                }
            },
            messages: {
                name: {
                    required: "Please enter a name",
                    minlength: "Your name must min 3 characters",
                    maxlength: "Your name must max 16 characters",
                    regex: "Input only letters"
                }
                ,
                surname: {
                    required: "Please enter a surname",
                    minlength: "Your surname must min 3 characters",
                    maxlength: "Your surname must max 16 characters",
                    regex: "Input only letters"
                }
                ,
                experience: {
                    required: "Please enter experience",
                    number: "Input only digits",
                    min: "Value must be greater than 0",
                    max: "Value must be less than 20",
                    regex: "Input only digits"
                }
                ,
                email: {
                    required: "Please enter email",
                    email: "Input email address format Email@gmail.com",
                    minlength: "Email length must be greater than 5",
                    maxlength: "Email length must be less than 30"
                }
                ,
                dateOfBirth: {
                    required: "Please enter date",
                    date: "Input correct date",
                    greaterThan: "Date can't greater then today"
                }
            },
            submitHandler: (event) => employeeController.createOrUpdateEmployee(event)
        });
    };
}
