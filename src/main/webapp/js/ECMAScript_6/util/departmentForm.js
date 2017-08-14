export default class DepartmentForm {
    constructor() {
    };

    static departmentForm(departmentController, data) {

        $('#app').text('');

        let table = $('<table>');

        table.addClass("table table-hover");

        let tr = $('<tr>');
        tr.append($('<th>').text('ID'));
        tr.append($('<th>').text('Name'));
        tr.append($('<th>').text('Employees'));
        tr.append($('<th>').text('Update'));
        tr.append($('<th>').text('Delete'));
        table.append(tr);

        $.each(data, function (index, department) {
            let tr = $('<tr>');

            let showDepEmpButton = $('<button>').attr('class', 'li-color').attr('value', department.id)
                .on('click', (event) => departmentController.departmentEmployees(event)).text('Employees');

            let updateDep = $('<button>').attr('class', 'li-color').attr('value', department.id)
                .on('click', (event) => departmentController.getDepartment(event)).text('Update');

            let deleteDep = $('<button>').attr('class', 'li-color').attr('value', department.id)
                .on('click', (event) => departmentController.deleteDepartment(event)).text('Delete');

            tr.append($('<td>').append(department.id));
            tr.append($('<td>').append(department.name));
            tr.append($('<td>').append(showDepEmpButton));
            tr.append($('<td>').append(updateDep));
            tr.append($('<td>').append(deleteDep));

            table.append(tr);
        });

        $('#app').append(table);
    }
}