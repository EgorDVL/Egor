import DepartmentService from "../js_service/department-service";
import DepartmentForm from "../util/departmentForm";
import DepartmentCreateUpdateForm from "../util/departmentCreateUpdateForm";
import EmployeeForm from "../util/employeeForm";
import Error from "../util/errorMessages";

export default class DepartmentController {
    constructor() {
        this.departmnetService = new DepartmentService();
        this.error = new Error();
    }

    all() {
        this.departmnetService
            .findAll()
            .then(data => {
                DepartmentForm.departmentForm(this, data);
            })
            .catch(err => {
                this.error.error(err);
            });
    }

    createOrUpdateDepartment(event) {
        this.departmnetService
            .createDepartmentService(event)
            .then(() => {
                this.all();
            })
            .catch(err => {
                this.error.errorDuplicateName(err);
            });
    }

    createFormDepartment() {
        DepartmentCreateUpdateForm.showDepartmentCreateUpdateForm(this);
    }

    getDepartment(event) {
        this.departmnetService
            .getDepartmentService(event)
            .then((data) => {
                DepartmentCreateUpdateForm.showDepartmentCreateUpdateForm(this, data);
            })
            .catch(err => {
                this.error.error(err);
            });
    }

    deleteDepartment(event) {
        this.departmnetService
            .deleteDepartmentService(event)
            .then(() => {
                this.all();
            })
            .catch(err => {
                this.error.error(err);
            });
    }

    departmentEmployees(event) {
        this.departmnetService
            .allDepartmentEmployees(event)
            .then(data => {
                EmployeeForm.employeeForm(this, data);
            })
            .catch(err => {
                this.error.error(err);
            });
    }
}