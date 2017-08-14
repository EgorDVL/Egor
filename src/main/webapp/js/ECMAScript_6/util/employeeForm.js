export default class EmployeeForm {
    constructor() {
    };

    static employeeForm(employeeController, data) {
        $('#app').text('');

        let table = $('<table>');
        table.addClass("table table-hover");

        let tr = $('<tr>');
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
            let tr = $('<tr>');

            let updateEmpl = $('<button>').attr('class', 'li-color').attr('value', employee.id)
                .on('click', (event) => employeeController.getEmployee(event)).text('Update');

            let deleteEmpl = $('<button>').attr('class', 'li-color').attr('value', employee.id)
                .on('click', (event) => employeeController.deleteEmployee(event)).text('Delete');

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
}