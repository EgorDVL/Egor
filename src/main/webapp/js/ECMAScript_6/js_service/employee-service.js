export default class EmployeeService {
    constructor() {
    };

    findAllEmpl() {
        return new Promise((resolve, reject) => {
            $.ajax({
                url: '/employee/all',
                type: 'GET',
                success: function (data) {
                    resolve(data);
                },
                error: function (date) {
                    reject(date);
                }
            })
        });
    }

    getEmployeeService(event) {
        return new Promise((resolve, reject) => {
            let employeeId = event.currentTarget.value;

            $.ajax({
                url: '/employee/getEmployee',
                data: {employeeId: employeeId},
                type: 'GET',
                dataType: 'json',
                success: function (data) {
                    resolve(data);
                },
                error: function (date) {
                    reject(date);
                }
            });
        });
    }

    createEmployeeService(event) {
        return new Promise((resolve, reject) => {

            let employeeId = $('#idEmpl').val();
            let employeeName = $('#nameEmpl').val();
            let employeeSurname = $('#surnameEmpl').val();
            let employeeExperience = $('#experienceEmpl').val();
            let employeeEmail = $('#emailEmpl').val();
            let employeeDateOfBirth = $('#dateOfBirthEmpl').val();
            let employeeDepartmentId = $('#departmentIdEmpl').val();

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
                    resolve();
                },
                error: function (data) {
                    reject(data);
                }
            });
        });
    }

    deleteEmployeeService(event) {
        return new Promise((resolve, reject) => {
            let employeeId = event.currentTarget.value;
            $.ajax({
                url: '/employee/delete',
                type: 'POST',
                dataType: 'json',
                data: {
                    employeeId: employeeId
                },
                success: function () {
                    resolve();
                }, error: function (data) {
                    reject(data);
                }
            });
        });
    }
}
