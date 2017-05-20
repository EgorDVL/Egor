package zhyzhko.tasks;

import zhyzhko.tasks.task1.Task1;
import zhyzhko.tasks.task3.Task3;

import java.io.IOException;

/**
 * Created by Egor on 19.05.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("-------- TASK 1 --------");
        Task3 task3 = new Task3();
        System.out.println("Sum of the digits in the number 100! = " + task3.calculate(100) + " \n");

        System.out.println("-------- TASK 2 --------");
        zhyzhko.tasks.task2.Main.main(new String[]{});
        System.out.println();

        System.out.println("-------- TASK 3 --------");
        Task1 task1 = new Task1();
        System.out.println(task1.generateBrackets(3));

    }

}
