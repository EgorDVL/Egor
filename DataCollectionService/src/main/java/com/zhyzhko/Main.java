package com.zhyzhko;

import com.zhyzhko.configuration.ConfigApp;
import com.zhyzhko.dao.FieldDao;
import com.zhyzhko.dao.FieldResponseDao;
import com.zhyzhko.dao.entity.FieldResponse;
import com.zhyzhko.dao.entity.TypeValue;
import com.zhyzhko.dao.entity.enums.TypeEnum;
import com.zhyzhko.dao.impl.FieldDaoImpl;
import com.zhyzhko.dto.*;
import com.zhyzhko.service.*;
import com.zhyzhko.util.converter.FieldResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Egor on 09.04.2017.
 */
public class Main {
    public static void main(String[] args) throws SQLException {

//        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
//
//        FieldResponseService fieldResponseService = context.getBean(FieldResponseService.class);
//        System.out.println(fieldResponseService.getAllFieldResponse());
//        System.out.println(fieldResponseService.getFieldResponse(1));
//        fieldResponseService.createFieldResponse(new FieldResponseDto(4,2,1,"Egor"));
//        fieldResponseService.updateFieldResponse(new FieldResponseDto(4,2,1,"Egorrr"));
//        fieldResponseService.deleteFieldResponse(5);
//
//
//        FieldService fieldService = context.getBean(FieldService.class);
//        fieldService.updateRequired(1,1);
//        System.out.println(fieldService.getAllField());
//        System.out.println(fieldService.getField(1));
//        fieldService.createField(new FieldDto(4,"Lol",4,1,1));
//        fieldService.updateField(new FieldDto(4,"Lolol",4,1,1));
//        fieldService.deleteFielde(4);
//
//        RequiredService requiredService = context.getBean(RequiredService.class);
//        System.out.println(requiredService.getAllRequired());
//        System.out.println(requiredService.getRequired(1));
//        requiredService.createRequired(new RequiredDto(3,true));
//        requiredService.updateRequired(new RequiredDto(3,false));
//        requiredService.deleteRequired(3);
//
//        ResponseService responseService = context.getBean(ResponseService.class);
//        System.out.println(responseService.getAllResponse());
//        System.out.println(responseService.getResponse(1));
//        responseService.createResponse(new ResponseDto(4));
//        responseService.deleteResponse(4);
//
//        StatusService statusService = context.getBean(StatusService.class);
//        System.out.println(statusService.getAllStatus());
//        System.out.println(statusService.getStatus(1));
//        statusService.createStatus(new StatusDto(3,true));
//        statusService.updateStatus(new StatusDto(3,false));
//        statusService.deleteStatus(3);
//
//        TypeService typeService = context.getBean(TypeService.class);
//        System.out.println(typeService.getAllType());
//        System.out.println(typeService.getType(1));
//        typeService.createType(new TypeDto(8,"DATE"));
//        typeService.updateType(new TypeDto(8,"DATE"));
//        typeService.deleteType(8);
//
//        TypeValueService typeValueService = context.getBean(TypeValueService.class);
//        System.out.println(typeValueService.getAllTypeValueByTypeId(1));
//        System.out.println(typeValueService.getAllTypeValue());
//        System.out.println(typeValueService.getTypeValue(1));
//        typeValueService.createTypeValue(new TypeValueDto(5,"20.04.1999",7));
//        typeValueService.updateTypeValue(new TypeValueDto(5,"20.05.1999",7));
//        typeValueService.deleteTypeValue(5);
    }
}
