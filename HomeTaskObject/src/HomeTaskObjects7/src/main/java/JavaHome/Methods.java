package JavaHome;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 27.03.2016.
 */
public class Methods {
    private int yearNow = 2016;
    ArrayList<Car> car = new ArrayList<>();

    public void addCar(Car c) {
        car.add(c);
    }

    public void showAll() {
        for (Car c : car) {
            System.out.println(c);
        }
    }

    public List<Car> carMarka(String marka) {
        List<Car> newCar = new ArrayList<>();
        for (Car c : car) {
            if (c.getMarka().equals(marka)) {
                newCar.add(c);
            }
        }
        return newCar;
    }

    public ArrayList<Car> carMarkaYear(String marka, int countYear) {
        ArrayList<Car> newCar = new ArrayList<>();
        for (Car c : car) {
            int countYearVupuska = yearNow - c.getYearVupuska();
            if (countYear <= countYearVupuska) {
                if (c.getMarka().equals(marka)) {
                    newCar.add(c);
                }
            }
        }
        return newCar;
    }

    public ArrayList<Car> carYearAndPrice(int yearVupyska, int price) {
        ArrayList<Car> newCar = new ArrayList<>();
        for (Car c : car) {
            if (c.getYearVupuska() == yearVupyska) {
                if (c.getPrice() >= price) {
                    newCar.add(c);
                }
            }
        }
        return newCar;
    }
}
