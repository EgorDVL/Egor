package bean.enams;

public enum ManufacturerEnam {
    APPLE(1), SAMSUNG(2), LG(3), NOKIA(4), LENOVO(5);

    private int value;

    ManufacturerEnam(int value) {
        this.value = value;
    }

    public int getValueInt() {
        return value;
    }

    public static ManufacturerEnam getValue(String manufacturer) {
        for (ManufacturerEnam manufacturerEnam : values()) {
            if (manufacturerEnam.toString().equalsIgnoreCase(manufacturer)) {
                return manufacturerEnam;
            }
        }
        return null;
    }
}
