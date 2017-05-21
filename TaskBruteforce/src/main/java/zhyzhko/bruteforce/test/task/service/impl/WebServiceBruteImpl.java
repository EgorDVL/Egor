package zhyzhko.bruteforce.test.task.service.impl;

import org.springframework.stereotype.Service;
import zhyzhko.bruteforce.test.task.service.WebServiceBrute;

/**
 * Created by Egor on 22.05.2017.
 */
@Service
public class WebServiceBruteImpl implements WebServiceBrute {
    char[] canUse = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int result = 0;

    @Override
    public int getPassword(String password, int maxlen) {
        int k = 0;
        while (k < canUse.length) {
            nextString(Character.toString(canUse[k]), password, maxlen);
            k++;
        }
        return result;
    }

    private void nextString(String s, String password, int maxlen) {
        int i = 0;
        while (i < canUse.length) {
            if ((s + Character.toString(canUse[i])).length() <= maxlen) {
                nextString(s + Character.toString(canUse[i]), password, maxlen);
            }
            if (s.equals(password)) {
                result = Integer.parseInt(s);
                break;
            }
            i++;
        }
    }
}
