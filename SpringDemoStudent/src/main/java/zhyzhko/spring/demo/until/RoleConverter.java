package zhyzhko.spring.demo.until;


import zhyzhko.spring.demo.dao.entity.enums.RoleEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by Andrii_Khodyka on 11/2/2016.
 */

@Converter
public class RoleConverter implements AttributeConverter<RoleEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(RoleEnum role) {
        if (role == null) {
            return null;
        }
        return role.getCode();
    }

    @Override
    public RoleEnum convertToEntityAttribute(Integer code) {
        if (code == null) {
            return null;
        }
        return RoleEnum.fromCode(code);
    }
}
