package db;

/**
 * Created by Egor on 02.11.2016.
 */
public class QueryConstructor {
    public static StringBuilder category = new StringBuilder();
    public static StringBuilder manufacturer = new StringBuilder();
    public static StringBuilder mainCameraBuilder = new StringBuilder();
    public static StringBuilder screenSizeBuilder = new StringBuilder();
    public static StringBuilder memoryBuilder = new StringBuilder();
    public static StringBuilder colorBuilder = new StringBuilder();
    public static StringBuilder ramBuilder = new StringBuilder();
    public static StringBuilder priceFromBuilder = new StringBuilder();
    public static StringBuilder priceToBuilder = new StringBuilder();

    public void cleanConstructor() {
        category.delete(0, category.length());
        manufacturer.delete(0, manufacturer.length());
        mainCameraBuilder.delete(0, mainCameraBuilder.length());
        screenSizeBuilder.delete(0, screenSizeBuilder.length());
        memoryBuilder.delete(0, memoryBuilder.length());
        colorBuilder.delete(0, colorBuilder.length());
        ramBuilder.delete(0, ramBuilder.length());
        priceFromBuilder.delete(0, priceFromBuilder.length());
        priceToBuilder.delete(0, priceToBuilder.length());
    }

    public String constructor(String[] categoryId, String[] manufacturerId,
                              String priceFrom, String priceTo, String[] mainCamera,
                              String[] screenSize, String[] memory, String[] color, String[] ram) {
        inspectionParam(categoryId, manufacturerId, priceFrom, priceTo, mainCamera, screenSize, memory, color, ram);
        return sqlBuilder();
    }

    private void inspectionParam(String[] categoryId, String[] manufacturerId, String priceFrom, String priceTo, String[] mainCamera, String[] screenSize, String[] memory, String[] color, String[] ram) {
        if (categoryId != null) {
            for (String categoryStr : categoryId) {
                category.append("'" + categoryStr + "'" + ",");
            }
            category.deleteCharAt(category.length() - 1);
        } else {
            category.append("");
        }
        if (manufacturerId != null) {
            for (String manufacturerStr : manufacturerId) {
                manufacturer.append("'" + manufacturerStr + "'" + ",");
            }
            manufacturer.deleteCharAt(manufacturer.length() - 1);
        } else {
            manufacturer.append("");
        }
        if (priceFrom == null || priceFrom.isEmpty()) {
            priceFromBuilder.append("0");
        } else {
            priceFromBuilder.append(priceFrom);
        }
        if (priceTo == null || priceTo.isEmpty()) {
            priceToBuilder.append("1000000");
        } else {
            priceToBuilder.append(priceTo);
        }
        if (mainCamera != null) {
            for (String mainCameraStr : mainCamera) {
                mainCameraBuilder.append("'" + mainCameraStr + "'" + ",");
            }
            mainCameraBuilder.deleteCharAt(mainCameraBuilder.length() - 1);
        } else {
            mainCameraBuilder.append("");
        }
        if (screenSize != null) {
            for (String screenSizeStr : screenSize) {
                screenSizeBuilder.append("'" + screenSizeStr + "'" + ",");
            }
            screenSizeBuilder.deleteCharAt(screenSizeBuilder.length() - 1);
        } else {
            screenSizeBuilder.append("");
        }
        if (memory != null) {
            for (String memoryStr : memory) {
                memoryBuilder.append("'" + memoryStr + "'" + ",");
            }
            memoryBuilder.deleteCharAt(memoryBuilder.length() - 1);
        } else {
            memoryBuilder.append("");
        }
        if (color != null) {
            for (String colorStr : color) {
                colorBuilder.append("'" + colorStr + "'" + ",");
            }
            colorBuilder.deleteCharAt(colorBuilder.length() - 1);
        } else {
            colorBuilder.append("");
        }
        if (ram != null) {
            for (String ramStr : ram) {
                ramBuilder.append("'" + ramStr + "'" + ",");
            }
            ramBuilder.deleteCharAt(ramBuilder.length() - 1);
        } else {
            ramBuilder.append("");
        }
    }

    private String sqlBuilder() {
        QueryBuilderSQL queryBuilderSQL = new QueryBuilderSQL();
        QueryBuilderSQL queryBuilderSQLSubquery = new QueryBuilderSQL();
        String subquery;
        if (mainCameraBuilder.toString().isEmpty()
                && screenSizeBuilder.toString().isEmpty()
                && memoryBuilder.toString().isEmpty()
                && colorBuilder.toString().isEmpty()
                && ramBuilder.toString().isEmpty()) {
            subquery = "";
        } else {
            subquery = queryBuilderSQLSubquery.select().param("characteristicId")
                    .from("characteristic").where().in("mainCamera", mainCameraBuilder.toString())
                    .in("screenSize", screenSizeBuilder.toString()).in("memory", memoryBuilder.toString())
                    .in("color", colorBuilder.toString()).in("ram", ramBuilder.toString()).buildWithOutEnd();
        }

        String query = queryBuilderSQL.select().all().from("Product").where()
                .in("categoryId", category.toString()).in("manufacturerId", manufacturer.toString())
                .between("price", priceFromBuilder.toString(), priceToBuilder.toString())
                .in("characteristicId", subquery).build();
        return query;
    }
}
