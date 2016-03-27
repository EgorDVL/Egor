package JavaHome;

/**
 * Created by Egor on 27.03.2016.
 */
public class Car {
    private int id;
    private String Marka;
    private String Model;
    private int yearVupuska;
    private String color;
    private int price;
    private int regNumber;

    public Car(int id, String marka, String model, int yearVupuska, String color, int price, int regNumber) {
        this.id = id;
        Marka = marka;
        Model = model;
        this.yearVupuska = yearVupuska;
        this.color = color;
        this.price = price;
        this.regNumber = regNumber;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String marka) {
        Marka = marka;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYearVupuska() {
        return yearVupuska;
    }

    public void setYearVupuska(int yearVupuska) {
        this.yearVupuska = yearVupuska;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", Marka='" + Marka + '\'' +
                ", Model='" + Model + '\'' +
                ", yearVupuska=" + yearVupuska +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", regNumber=" + regNumber +
                '}';
    }
}
