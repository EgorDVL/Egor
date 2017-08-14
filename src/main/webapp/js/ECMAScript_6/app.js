import DepartmentController from "../ECMAScript_6/js_controller/department-controller";
import EmployeeController from "../ECMAScript_6/js_controller/employee-controller";

import '../lib/jquery.validate.min';
import "../../css/main.css";

export default class Main {

    constructor() {
        this.departmentController = new DepartmentController();
        this.employeeController = new EmployeeController();
    }

    init() {
        $(document).ready(() => {

            let div = $('<div>').attr('class', 'main-body-menu');

            let ulDepartment = $('<ul>').attr('class', 'nav').text("Department");
            let ulEmployee = $('<ul>').attr('class', 'nav').text("Employee");

            let liDepartmentCreate = $('<li>').attr('class', 'nav-header');
            let liDepartmentShow = $('<li>').attr('class', 'nav-header');

            let liEmployeeCreate = $('<li>').attr('class', 'nav-header');
            let liEmployeeShow = $('<li>').attr('class', 'nav-header');


            let buttonCreateDep = $('<button>').attr('class', 'li-color')
                .on('click', () => {
                    this.departmentController.createFormDepartment()
                }).text("Create");


            let buttonShowDep = $('<button>').attr('class', 'li-color')
                .on('click', () => {
                    this.departmentController.all()
                }).text("Show departments");


            let buttonCreateEmpl = $('<button>').attr('class', 'li-color')
                .on('click', () => {
                    this.employeeController.createFormCreateEmpl()
                }).text("Create");


            let buttonShowEmpl = $('<button>').attr('class', 'li-color')
                .on('click', () => {
                    this.employeeController.allEmpl()
                }).text("Show employees");

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
    }
}

new Main().init();