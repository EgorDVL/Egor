$(document).ready(function mainPanel() {
    var div = $('<div>').attr('class', 'main-body-menu');

    var ulDepartment = $('<ul>').attr('class', 'nav').text("Department");
    var ulEmployee = $('<ul>').attr('class', 'nav').text("Employee");

    var liDepartmentCreate = $('<li>').attr('class', 'nav-header');
    var liDepartmentShow = $('<li>').attr('class', 'nav-header');

    var liEmployeeCreate = $('<li>').attr('class', 'nav-header');
    var liEmployeeShow = $('<li>').attr('class', 'nav-header');


    var buttonCreateDep = $('<button>').attr('class', 'li-color')
        .on('click', showDepartmentCreateOrUpdateForm).text("Create");

    var buttonShowDep = $('<button>').attr('class', 'li-color')
        .on('click', showAllDepartments).text("Show departments");

    var buttonCreateEmpl = $('<button>').attr('class', 'li-color')
        .on('click', showEmployeeCreateOrUpdateForm).text("Create");

    var buttonShowEmpl = $('<button>').attr('class', 'li-color')
        .on('click', showAllEmployees).text("Show employees");

    liDepartmentCreate.append(buttonCreateDep);
    liDepartmentShow.append(buttonShowDep);

    liEmployeeCreate.append(buttonCreateEmpl);
    liEmployeeShow.append(buttonShowEmpl);

    ulDepartment.append(liDepartmentCreate);
    ulDepartment.append(liDepartmentShow);

    ulEmployee.append(liEmployeeCreate);
    ulEmployee.append(liEmployeeShow);

    div.append(ulDepartment);
    div.append(ulEmployee);

    $('#block').append(div);
});

//DEPARTMENT

function showAllDepartments() {
    $.ajax({
        url: '/department/all',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#app').text('');
            showAllDepartmentForm(data);
        },
        error: function (date) {
            var message = JSON.parse(date.responseText);
            $('#error').text(message.msg);
        }
    });
}

function showAllDepartmentForm(data) {
    var table = $('<table>');

    table.addClass("table table-hover");

    var tr = $('<tr>');
    tr.append($('<th>').text('ID'));
    tr.append($('<th>').text('Name'));
    tr.append($('<th>').text('Employees'));
    tr.append($('<th>').text('Update'));
    tr.append($('<th>').text('Delete'));
    table.append(tr);

    $.each(data, function (index, department) {
        var tr = $('<tr>');

        var showDepEmpButton = $('<button>').attr('class', 'li-color').attr('value', department.id)
            .on('click', departmentEmployees).text('Employees');

        var updateDep = $('<button>').attr('class', 'li-color').attr('value', department.id)
            .on('click', getDepartment).text('Update');

        var deleteDep = $('<button>').attr('class', 'li-color').attr('value', department.id)
            .on('click', deleteDepartment).text('Delete');

        tr.append($('<td>').append(department.id));
        tr.append($('<td>').append(department.name));
        tr.append($('<td>').append(showDepEmpButton));
        tr.append($('<td>').append(updateDep));
        tr.append($('<td>').append(deleteDep));

        table.append(tr);
    });

    $('#app').append(table);
}

function deleteDepartment(event) {
    event.preventDefault();
    var departmentId = event.currentTarget.value;
    $.ajax({
        url: '/department/delete',
        type: 'POST',
        dataType: 'json',
        data: {
            departmentId: departmentId
        },
        success: function () {
            showAllDepartments();
        },
        error: function (date) {
            var message = JSON.parse(date.responseText);
            $('#error').text(message.msg);
        }
    });
}

function getDepartment(event) {
    event.preventDefault();

    var departmentId = event.currentTarget.value;
    $.ajax({
        url: '/department/getDepartment',
        type: 'GET',
        data: {
            departmentId: departmentId
        },
        dataType: 'json',
        success: function (date) {
            $('#app').text('');
            showDepartmentCreateOrUpdateForm(date);
        },
        error: function (date) {
            var message = JSON.parse(date.responseText);
            $('#error').text(message.msg);
        }
    });
}

function showDepartmentCreateOrUpdateForm(department) {
    $('#app').text('');

    var departmentId = department.id;
    var name = department.name;

    var form = $('<form id="myForm">');
    form.addClass("container");

    var inputDepartmentId = $('<input>').attr('name', 'id').attr('id', 'idDep').attr('type', 'hidden')
        .attr('value', (departmentId ? departmentId : ''));

    var labelName = $('<label>').attr('class', 'label-employee-name').attr('for', 'name').text('Name');

    var inputName = $('<input>').attr('name', 'name').attr('id', 'nameDep').attr('type', 'text')
        .attr('value', (name ? name : ''));

    var createDepartmentButton = $('<button>').attr('class', 'button-create-department')
        .on('click', validDepartment).text('Save');

    form.append(inputDepartmentId);
    form.append(labelName);
    form.append($('<br>'));
    form.append(inputName).append($('<div id="errMess"></div>').hide().slideDown());
    form.append($('<br>'));
    form.append(createDepartmentButton);

    $('#app').append(form);
}

function validDepartment() {
    $.validator.addMethod(
        "regex",
        function (value, element, regexp) {
            return regexp.test(value);
        }
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
        submitHandler: function (event) {
            createDepartment(event);
        }
    });
}

function createDepartment() {
    event.preventDefault();

    var departmentId = $('#idDep').val();
    var departmentName = $('#nameDep').val();

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: '/department/departmentExecute',
        type: 'POST',
        data: JSON.stringify({
            id: departmentId,
            name: departmentName
        }),
        success: function () {
            $('#app').text('');
            showAllDepartments();
        },
        error: function (date) {
            var message = JSON.parse(date.responseText);
            $('#errMess').text(message.name);
        }
    });
}

function departmentEmployees(event) {
    event.preventDefault();
    var departmentId = event.currentTarget.value;

    $.ajax({
        url: '/employee/allDepartmentEmployees',
        type: 'GET',
        dataType: 'json',
        data: {
            departmentId: departmentId
        },
        success: function (data) {
            $('#app').text('');
            showAllEmployeeForm(data);
        },
        error: function (date) {
            var message = JSON.parse(date.responseText);
            $('#error').text(message.msg);
        }
    });
}


//EMPLOYEE

function showAllEmployees() {
    $.ajax({
        url: '/employee/all',
        type: 'GET',
        success: function (data) {
            $('#app').text('');
            showAllEmployeeForm(data);
        },
        error: function (date) {
            var message = JSON.parse(date.responseText);
            $('#error').text(message.msg);
        }
    });
}

function showAllEmployeeForm(data) {
    var table = $('<table>');
    table.addClass("table table-hover");

    var tr = $('<tr>');
    tr.append($('<th>').text('ID'));
    tr.append($('<th>').text('Name'));
    tr.append($('<th>').text('Surname'));
    tr.append($('<th>').text('Experience'));
    tr.append($('<th>').text('Email'));
    tr.append($('<th>').text('Date of Birth'));
    tr.append($('<th>').text('Update'));
    tr.append($('<th>').text('Delete'));
    table.append(tr);

    $.each(data, function (index, employee) {
        var tr = $('<tr>');

        var updateEmpl = $('<button>').attr('class', 'li-color').attr('value', employee.id)
            .on('click', getEmployee).text('Update');

        var deleteEmpl = $('<button>').attr('class', 'li-color').attr('value', employee.id)
            .on('click', deleteEmployee).text('Delete');

        tr.append($('<td>').append(employee.id));
        tr.append($('<td>').append(employee.name));
        tr.append($('<td>').append(employee.surname));
        tr.append($('<td>').append(employee.experience));
        tr.append($('<td>').append(employee.email));
        tr.append($('<td>').append(employee.dateOfBirth));
        tr.append($('<td>').append(updateEmpl));
        tr.append($('<td>').append(deleteEmpl));
        table.append(tr);
    });
    $('#app').append(table);
}

function deleteEmployee(event) {
    event.preventDefault();
    var employeeId = event.currentTarget.value;
    $.ajax({
        url: '/employee/delete',
        type: 'POST',
        dataType: 'json',
        data: {
            employeeId: employeeId
        },
        success: function () {
            showAllEmployees();
        }
    });
}

function getEmployee(event) {
    event.preventDefault();
    var employeeId = event.currentTarget.value;
    $.ajax({
        url: '/employee/getEmployee',
        data: {employeeId: employeeId},
        type: 'GET',
        dataType: 'json',
        success: function (date) {
            $('#app').text('');
            showEmployeeCreateOrUpdateForm(date);
        }
    });
};

function getListDepartment() {
    return $.ajax({
        url: '/department/all',
        type: 'GET',
        success: function (data) {
            return data;
        }
    });
}

function showEmployeeCreateOrUpdateForm(employee) {
    var departments = getListDepartment();

    departments.then(function (departmentList) {
            $('#app').text('');

            var form = $('<form id="myFormEmpl">');
            form.addClass("container");

            var inputEmployeeId = $('<input>').attr('name', 'id').attr('id', 'idEmpl').attr('type', 'hidden')
                .attr('value', (employee.id ? employee.id : ''));
            var inputName = $('<input>').attr('name', 'name').attr('id', 'nameEmpl').attr('type', 'text')
                .attr('value', (employee.name ? employee.name : ''));
            var inputSurname = $('<input>').attr('name', 'surname').attr('id', 'surnameEmpl').attr('type', 'text')
                .attr('value', (employee.surname ? employee.surname : ''));
            var inputExperience = $('<input>').attr('name', 'experience').attr('id', 'experienceEmpl').attr('type', 'number')
                .attr('value', (employee.experience ? employee.experience : 0));
            var inputEmail = $('<input>').attr('name', 'email').attr('id', 'emailEmpl').attr('type', 'email')
                .attr('value', (employee.email ? employee.email : ''));
            var inputDateOfBirth = $('<input>').attr('name', 'dateOfBirth').attr('id', 'dateOfBirthEmpl').attr('type', 'date')
                .attr('style', 'width: 173px;').attr('value', (employee.dateOfBirth ? employee.dateOfBirth : ''));


            var labelName = $('<label>').attr('class', 'label-employee-name').text('Name');
            var labelSurname = $('<label>').attr('class', 'label-employee-surname').text('Surname');
            var labelExperience = $('<label>').attr('class', 'label-employee-experience').text('Experience');
            var labelEmail = $('<label>').attr('class', 'label-employee-email').text('Email');
            var labelDateOfBirth = $('<label>').attr('class', 'label-employee-dateofBirth').text('Date of Birth');
            var labelDepartment = $('<label>').attr('class', 'label-employee-department').text('Department');

            var createEmployeeButton = $('<button>').attr('class', 'button-create-department')
                .on('click', validEmployee).text('Save');

            form.append(inputEmployeeId);
            form.append(labelName).append($('<br>')).append(inputName).append($('<br>'));
            form.append(labelSurname).append($('<br>')).append(inputSurname).append($('<br>'));
            form.append(labelExperience).append($('<br>')).append(inputExperience).append($('<br>'));
            form.append(labelEmail).append($('<br>')).append(inputEmail).append($('<div id="errMessEmployee"></div>'));
            form.append(labelDateOfBirth).append($('<br>')).append(inputDateOfBirth).append($('<br>'));
            form.append(labelDepartment).append($('<br>'));

            var select = $('<select>').attr('class', 'input-create-employee').attr('id', 'departmentIdEmpl')
                .attr('style', 'width: 173px;').attr('required', 'true');

            if (employee.department) {
                var optionDepartment = $('<option>').attr('value', employee.department.id).attr('selected', 'true')
                    .text(employee.department.name);
                select.append(optionDepartment);
            }
            $.each(departmentList, function (index, dep) {
                var options = $('<option>').attr('value', dep.id).text(dep.name);
                select.append(options);
            });

            form.append(select).append($('<br>'));
            form.append(createEmployeeButton);

            $('#app').append(form);
        }
    );
}

function validEmployee() {
    $.validator.addMethod(
        "regex",
        function (value, element, regexp) {
            return regexp.test(value);
        }
    );

    $.validator.addMethod(
        "greaterThan",
        function (value, element, params) {
            return new Date(value) < new Date();
        });

    $("#myFormEmpl").validate({
        rules: {
            name: {
                required: true,
                minlength: 3,
                maxlength: 16,
                regex: /^[a-zA-Z]+$/
            },
            surname: {
                required: true,
                minlength: 3,
                maxlength: 16,
                regex: /^[a-zA-Z]+$/
            },
            experience: {
                required: true,
                number: true,
                min: 0,
                max: 20,
                regex: /^[0-9]+$/
            },
            email: {
                required: true,
                email: true,
                minlength: 5,
                maxlength: 30
            },
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
            },
            surname: {
                required: "Please enter a surname",
                minlength: "Your surname must min 3 characters",
                maxlength: "Your surname must max 16 characters",
                regex: "Input only letters"
            },
            experience: {
                required: "Please enter experience",
                number: "Input only digits",
                min: "Value must be greater than 0",
                max: "Value must be less than 20",
                regex: "Input only digits"
            },
            email: {
                required: "Please enter email",
                email: "Input email address format Email@gmail.com",
                minlength: "Email length must be greater than 5",
                maxlength: "Email length must be less than 30"
            },
            dateOfBirth: {
                required: "Please enter date",
                date: "Input correct date",
                greaterThan: "Date can't greater then today"
            }
        },
        submitHandler: function (event) {
            createEmployee(event);
        }
    });
};

function createEmployee() {
    event.preventDefault();

    var employeeId = $('#idEmpl').val();
    var employeeName = $('#nameEmpl').val();
    var employeeSurname = $('#surnameEmpl').val();
    var employeeExperience = $('#experienceEmpl').val();
    var employeeEmail = $('#emailEmpl').val();
    var employeeDateOfBirth = $('#dateOfBirthEmpl').val();
    var employeeDepartmentId = $('#departmentIdEmpl').val();

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: '/employee/employeeExecute',
        type: 'POST',
        data: JSON.stringify({
            id: employeeId,
            name: employeeName,
            surname: employeeSurname,
            experience: employeeExperience,
            email: employeeEmail,
            dateOfBirth: employeeDateOfBirth,
            department: {
                id: employeeDepartmentId,
                name: ''
            }
        }),
        success: function () {
            $('#app').text('');
            showAllEmployees();
        },
        error: function (date) {
            var message = JSON.parse(date.responseText);
            $('#errMessEmployee').text(message.email);
        }
    });
};
