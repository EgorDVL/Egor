package bean;

public class Product {
    private int productId;
    private String name;
    private int price;
    private int count;
    private int categoryId;
    private int descriptionId;
    private int characteristicId;
    private int manufacturerId;

    public Product() {
        super();
    }

    public Product(String name, int price, int count, int descriptionId, int characteristicId, int manufacturerId, int categoryId) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.descriptionId = descriptionId;
        this.characteristicId = characteristicId;
        this.manufacturerId = manufacturerId;
        this.categoryId = categoryId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public int getCharacteristicId() {
        return characteristicId;
    }

    public void setCharacteristicId(int characteristicId) {
        this.characteristicId = characteristicId;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;

        return productId == product.productId;

    }

    @Override
    public int hashCode() {
        return productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", categoryId=" + categoryId +
                ", descriptionId=" + descriptionId +
                ", characteristicId=" + characteristicId +
                ", manufacturerId=" + manufacturerId +
                '}';
    }
}
