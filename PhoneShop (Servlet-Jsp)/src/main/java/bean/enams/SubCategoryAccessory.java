package bean.enams;

public enum SubCategoryAccessory {
    COVERS(1), PROTECTIVE_SCREEN(2), PROTECTIVE_GLASSES(3), HEADSET(4), CHARGING_DEVICE(5), MONOPODS_FOR_SELFIE(6), BATTARIES(7);

    private int value;

    SubCategoryAccessory(int value) {
        this.value = value;
    }

    public int getValueInt() {
        return value;
    }

    public static SubCategoryAccessory getValue(String subcat) {
        for (SubCategoryAccessory subCategoryAccessory : values()) {
            if (subCategoryAccessory.toString().equalsIgnoreCase(subcat)) {
                return subCategoryAccessory;
            }
        }
        return null;
    }
}
