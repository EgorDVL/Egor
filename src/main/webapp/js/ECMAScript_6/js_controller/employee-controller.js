import EmployeeService from "../js_service/employee-service";
import EmployeeForm from "../util/employeeForm";
import DepartmentService from "../js_service/department-service";
import EmployeeCreateUpdateForm from "../util/employeeCreateUpdateForm";
import Error from "../util/errorMessages";

export default class EmployeeController {
    constructor() {
        this.employeeService = new EmployeeService();
        this.departmentService = new DepartmentService();
        this.error = new Error();
    }

    allEmpl() {
        this.employeeService
            .findAllEmpl()
            .then(data => {
                EmployeeForm.employeeForm(this, data);
            })
            .catch(err => {
                this.error.error(err);
            });
    }

    createFormCreateEmpl() {
        this.departmentService.findAll()
            .then((departments) => {
                EmployeeCreateUpdateForm.showEmployeeCreateOrUpdateForm(this, departments);
            })
            .catch(err => {
                this.error.error(err);
            });
    }

    createOrUpdateEmployee(event) {
        this.employeeService
            .createEmployeeService(event)
            .then(() => {
                this.allEmpl();
            })
            .catch(err => {
                this.error.errorDuplicateEmail(err);
            })
    }

    getEmployee(event) {
        this.departmentService.findAll()
            .then(departments => {

                this.employeeService
                    .getEmployeeService(event)
                    .then(employee => {
                        EmployeeCreateUpdateForm.showEmployeeCreateOrUpdateForm(this, departments, employee);
                    }).catch(err => {
                    this.error.error(err);
                });
            })
            .catch(err => {
                this.error.error(err);
            });
    }

    deleteEmployee(event) {
        this.employeeService
            .deleteEmployeeService(event)
            .then(() => {
                this.allEmpl();
            })
            .catch(err => {
                this.error.error(err);
            });
    }
}