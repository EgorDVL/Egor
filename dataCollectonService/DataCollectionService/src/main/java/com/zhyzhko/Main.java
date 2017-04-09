package com.zhyzhko;

import com.zhyzhko.configuration.ConfigApp;
import com.zhyzhko.dao.FieldDao;
import com.zhyzhko.dao.entity.TypeValue;
import com.zhyzhko.dao.impl.FieldDaoImpl;
import com.zhyzhko.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

/**
 * Created by Egor on 09.04.2017.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);

        FieldResponseService fieldResponseService = context.getBean(FieldResponseService.class);
        System.out.println(fieldResponseService.getAllFieldResponse());

        FieldService fieldService = context.getBean(FieldService.class);
        System.out.println(fieldService.getAllField());

        RequiredService requiredService = context.getBean(RequiredService.class);
        System.out.println(requiredService.getAllRequired());

        ResponseService responseService = context.getBean(ResponseService.class);
        System.out.println(responseService.getAllResponse());

        StatusService statusService = context.getBean(StatusService.class);
        System.out.println(statusService.getAllStatus());

        TypeService typeService = context.getBean(TypeService.class);
        System.out.println(typeService.getAllType());

        TypeValueService typeValueService = context.getBean(TypeValueService.class);
        System.out.println(typeValueService.getAllTypeValue());

    }
}
