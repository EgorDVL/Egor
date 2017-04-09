package zhyzhko.spring.demo.dao.entity.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;

/**
 * Created by Egor on 21.03.2017.
 */
public enum RoleEnum {
    ADMIN(1),
    USER(2);

    private int code;
    private static final String ROLE_PREFIX = "ROLE_";

    RoleEnum(int code) {
        this.code = code;
    }

    public static RoleEnum fromCode(int code) {
        return Arrays.stream(values())
                .filter(role -> role.code == code)
                .findFirst()
                .orElse(null);
    }

    public int getCode() {
        return this.code;
    }

    public String getAuthority() {
        return ROLE_PREFIX + name();
    }

    public SimpleGrantedAuthority getGrantedAuthority() {
        return new SimpleGrantedAuthority(this.getAuthority());
    }
}