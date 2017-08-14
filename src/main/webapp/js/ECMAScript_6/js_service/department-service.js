export default class DepartmentService {
    constructor() {
    };

    findAll() {
        return new Promise((resolve, reject) => {
            $.ajax({
                url: '/department/all',
                type: 'GET',
                dataType: 'json',
                success: function (data) {
                    resolve(data);
                },
                error: function (date) {
                    reject(date);
                }
            })
        });
    }

    createDepartmentService(event) {
        return new Promise((resolve, reject) => {

            let departmentId = $('#idDep').val();
            let departmentName = $('#nameDep').val();

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
                    resolve();
                },
                error: function (date) {
                    reject(date);
                }
            });
        });
    }

    getDepartmentService(event) {
        return new Promise((resolve, reject) => {
            let departmentId = event.currentTarget.value;
            $.ajax({
                url: '/department/getDepartment',
                type: 'GET',
                data: {
                    departmentId: departmentId
                },
                dataType: 'json',
                success: function (date) {
                    resolve(date);
                },
                error: function (date) {
                    reject(date);
                }
            });
        });
    }

    deleteDepartmentService(event) {
        return new Promise((resolve, reject) => {
            let departmentId = event.currentTarget.value;
            $.ajax({
                url: '/department/delete',
                type: 'POST',
                dataType: 'json',
                data: {
                    departmentId: departmentId
                },
                success: function () {
                    resolve();
                },
                error: function (data) {
                    reject(data);
                }
            });
        });
    }

    allDepartmentEmployees(event) {
        return new Promise((resolve, reject) => {
            let departmentId = event.currentTarget.value;
            $.ajax({
                url: '/employee/allDepartmentEmployees',
                type: 'GET',
                dataType: 'json',
                data: {
                    departmentId: departmentId
                },
                success: function (data) {
                    resolve(data);
                },
                error: function (date) {
                    reject(date);
                }
            });
        });
    }
}

