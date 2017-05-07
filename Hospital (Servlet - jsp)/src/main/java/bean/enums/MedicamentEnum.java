package bean.enums;

/**
 * Created by Egor on 05.01.2017.
 */
public enum MedicamentEnum {
    PILLS(1), INJECTION(2), POWDER(3);

    private int value;

    MedicamentEnum(int value) {
        this.value = value;
    }

    public int getValueInt() {
        return value;
    }

    public static MedicamentEnum getValue(String medicament) {
        for (MedicamentEnum medicamentEnum : values()) {
            if (medicamentEnum.toString().equalsIgnoreCase(medicament)) {
                return medicamentEnum;
            }
        }
        return null;
    }
}
