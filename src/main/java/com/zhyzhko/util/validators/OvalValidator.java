package com.zhyzhko.util.validators;

import com.zhyzhko.exception.ValidationException;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;
import net.sf.oval.integration.spring.SpringCheckInitializationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 07.07.17.
 */
@Component
public class OvalValidator {

    private static Validator validator = initCustomValidator();

    private static Validator initCustomValidator() {
        AnnotationsConfigurer annotationsConfigurer = new AnnotationsConfigurer();
        annotationsConfigurer.addCheckInitializationListener(SpringCheckInitializationListener.INSTANCE);
        return new Validator(annotationsConfigurer);
    }

    public void validate(Object object) {
        List<ConstraintViolation> violations = validator.validate(object);

        if (violations.size() > 0) {
            Map<String, String> errorMap = new HashMap<>();
            for (ConstraintViolation violation : violations) {
                OValContext context = violation.getContext();
                if (context instanceof FieldContext) {
                    String field = ((FieldContext) violation.getContext()).getField().getName();
                    errorMap.put(field, violation.getMessage());
                    throw new ValidationException(errorMap);
                }
            }
        }
    }
}
