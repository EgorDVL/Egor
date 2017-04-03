package web.form;

/**
 * Created by Egor on 11.11.2016.
 */
public class AddProductAccessoriesForm {
    private int subCategoryAccessory;
    private int manufacturerId;
    private String name;
    private int price;
    private int count;
    private String description;

    public AddProductAccessoriesForm() {
    }

    public AddProductAccessoriesForm(int subCategoryAccessory, int manufacturerId, String name, int price, int count, String description) {
        this.subCategoryAccessory = subCategoryAccessory;
        this.manufacturerId = manufacturerId;
        this.name = name;
        this.price = price;
        this.count = count;
        this.description = description;
    }

    public int getSubCategoryAccessory() {
        return subCategoryAccessory;
    }

    public void setSubCategoryAccessory(int subCategoryAccessory) {
        this.subCategoryAccessory = subCategoryAccessory;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AddProductAccessoriesForm{" +
                "subCategoryAccessory=" + subCategoryAccessory +
                ", manufacturerId=" + manufacturerId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", description='" + description + '\'' +
                '}';
    }
}
