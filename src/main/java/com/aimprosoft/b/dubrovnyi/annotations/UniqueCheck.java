//package com.aimprosoft.b.dubrovnyi.annotations;
//
//import com.aimprosoft.b.dubrovnyi.db.beans.Cooperator;
//import com.aimprosoft.b.dubrovnyi.db.beans.Department;
//import com.aimprosoft.b.dubrovnyi.services.CooperatorService;
//import com.aimprosoft.b.dubrovnyi.services.DepartmentService;
//import net.sf.oval.Validator;
//import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
//import net.sf.oval.context.OValContext;
//import net.sf.oval.exception.OValException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UniqueCheck extends AbstractAnnotationCheck<UniqueField> {
//
//    private final DepartmentService departmentService;
//
//    private final CooperatorService cooperatorService;
//
//    @Autowired
//    public UniqueCheck(DepartmentService departmentService,
//                       CooperatorService cooperatorService) {
//
//        this.departmentService = departmentService;
//        this.cooperatorService = cooperatorService;
//    }
//
//    @Override
//    public boolean isSatisfied(Object validatedObject, Object value,
//                               OValContext context, Validator validator)
//            throws OValException {
//
//        if (value == null) {
//            return true;
//        }
//
//        String objectValue = (String) value;
//
//        if (validatedObject instanceof Department) {
//            return isDepartmentUnique(objectValue);
//        }
//
//        if (validatedObject instanceof Cooperator) {
//            return isCooperatorUnique(objectValue);
//        }
//
//        throw new RuntimeException("This Annotation is not support "
//                + validatedObject.getClass().getName() + " class");
//    }
//
//    private boolean isDepartmentUnique(String departmentName) {
//
//        return departmentService
//                .getDepartment(departmentName) == null;
//    }
//
//    private boolean isCooperatorUnique(String cooperatorEmail) {
//
//        return cooperatorService.getCooperator(cooperatorEmail) == null;
//    }
//
//}
//
