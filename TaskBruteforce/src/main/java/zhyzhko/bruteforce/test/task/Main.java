package zhyzhko.bruteforce.test.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zhyzhko.bruteforce.test.task.configuration.ConfigApp;
import zhyzhko.bruteforce.test.task.service.WebServiceBrute;

/**
 * Created by Egor on 21.05.2017.
 */
public class Main {
    //    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
//        WebServiceBrute webServiceBrute = context.getBean(WebServiceBrute.class);
//
//        System.out.println(webServiceBrute.getPassword(53,4));
//    }



//    char[] canUse = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//    String password = "20";
//
//    int pr = 0;
//
//    int maxlen = 3;
//
//    public Main() {
//        int k = 0;
//        while (k < canUse.length) {
//            nextString(Character.toString(canUse[k]));
//            k++;
//        }
//        System.out.println(pr + " pr");
//    }
//
//    private void nextString(String s) {
//        int i = 0;
//        while (i < canUse1.length) {
//            if ((s + Character.toString(canUse[i])).length() <= maxlen) {
//                nextString(s + Character.toString(canUse[i]));
//            }
//            if (s.equals(password)) {
//                pr = Integer.parseInt(s);
//                break;
//            }
//            i++;
//        }
//    }
//
//    public static void main(String[] args) {
//        Main b = new Main();
//    }
}
