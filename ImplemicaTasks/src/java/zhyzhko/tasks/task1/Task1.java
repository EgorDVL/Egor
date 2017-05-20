package zhyzhko.tasks.task1;

import java.util.ArrayList;

/**
 * Created by Egor on 20.05.2017.
 */
public class Task1 {

    public void addBrackets(ArrayList<String> list, int leftBracket, int rightBracket, char[] str, int count) {

        // Incorrect state
        if (leftBracket < 0 || rightBracket < leftBracket) return;

        if (leftBracket == 0 && rightBracket == 0) { /*No more left brackets */
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
        /* If there are left brackets left, add a brackets */
            if (leftBracket > 0) {
                str[count] = '(';
                addBrackets(list, leftBracket - 1, rightBracket, str, count + 1);
            }

        /* If the expression is correct, add the right brackets */
            if (rightBracket > leftBracket) {
                str[count] = ')';
                addBrackets(list, leftBracket, rightBracket - 1, str, count + 1);
            }
        }
    }

    public ArrayList<String> generateBrackets(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<>();
        addBrackets(list, count, count, str, 0);
        return list;
    }
}
