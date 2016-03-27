package JavaHome;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Methods methods = new Methods();
        methods.addCar(new Car(1, "Lada", "Sedan", 1992, "red", 1500, 12345));
        methods.addCar(new Car(2, "Audi", "tt", 2006, "yellow", 12500, 12344));
        methods.addCar(new Car(3, "Mazda", "c5", 2006, "black", 9500, 12333));
        methods.addCar(new Car(4, "BMV", "x7", 2012, "blue", 45000, 12222));
        methods.addCar(new Car(4, "BMV", "x4", 2006, "red", 25000, 11111));
//    methods.showAll();
        List<Car> cars = methods.carMarka("BMV");
//        System.out.println(cars);
        ArrayList<Car> cars1 = methods.carMarkaYear("BMV", 5);
//        System.out.println(cars1);
        ArrayList<Car> cars2 = methods.carYearAndPrice(2006, 10000);
        System.out.println(cars2);
    }
}
