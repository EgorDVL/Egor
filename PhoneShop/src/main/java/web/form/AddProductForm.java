package web.form;

import bean.enams.CategoryEnam;
import bean.enams.ManufacturerEnam;

/**
 * Created by Egor on 11.11.2016.
 */
public class AddProductForm {
    private int manufacturer;
    private String name;
    private int price;
    private int count;
    private String description;
    private String color;
    private int memory;
    private double screenSize;
    private String processor;
    private int ram;
    private double frontCamera;
    private double mainCamera;

    public AddProductForm() {
    }

    public AddProductForm(int manufacturer, String name, int price, int count, String description, String color, int memory, double screenSize, String processor, int ram, double frontCamera, double mainCamera) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.price = price;
        this.count = count;
        this.description = description;
        this.color = color;
        this.memory = memory;
        this.screenSize = screenSize;
        this.processor = processor;
        this.ram = ram;
        this.frontCamera = frontCamera;
        this.mainCamera = mainCamera;
    }

    public int getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(int manufacturer) {
        this.manufacturer = manufacturer;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(double frontCamera) {
        this.frontCamera = frontCamera;
    }

    public double getMainCamera() {
        return mainCamera;
    }

    public void setMainCamera(double mainCamera) {
        this.mainCamera = mainCamera;
    }

    @Override
    public String toString() {
        return "AddProductForm{" +
                "manufacturer=" + manufacturer +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", memory=" + memory +
                ", screenSize=" + screenSize +
                ", processor='" + processor + '\'' +
                ", ram=" + ram +
                ", frontCamera=" + frontCamera +
                ", mainCamera=" + mainCamera +
                '}';
    }
}
