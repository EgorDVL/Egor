package bean.enums;

/**
 * Created by Egor on 05.01.2017.
 */
public enum ComplexityEnum {
    EAZY(1), NORMAL(2), HARD(3);
    private int value;

    ComplexityEnum(int value) {
        this.value = value;
    }

    public int getValueInt() {
        return value;
    }

    public static ComplexityEnum getValue(String complexity) {
        for (ComplexityEnum complexityEnum : values()) {
            if (complexityEnum.toString().equalsIgnoreCase(complexity)) {
                return complexityEnum;
            }
        }
        return null;
    }
}
