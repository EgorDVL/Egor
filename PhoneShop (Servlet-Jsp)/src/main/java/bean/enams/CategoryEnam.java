package bean.enams;

public enum CategoryEnam {
    PHONES(1), TABLETS(2), ACCESSORIES(3);

    private int id;

    private CategoryEnam(int id) {
        this.id = id;
    }

    public static CategoryEnam getValue(String category) {
        for (CategoryEnam categoryEnam : values()) {
            if (categoryEnam.toString().equalsIgnoreCase(category)) {
                return categoryEnam;
            }
        }
        return null;
    }

    public int getCategoryId() {
        return id;
    }


}
