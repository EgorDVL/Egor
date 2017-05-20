package zhyzhko.tasks.task3;

import java.math.BigInteger;

/**
 * Created by Egor on 20.05.2017.
 */
public class Task3 {

    public int calculate(int n) {
        return digitSum(factorial(new BigInteger("" + n))).intValue();
    }

    //Consider sum all digits
    private BigInteger digitSum(BigInteger n) {
        if (n.compareTo(BigInteger.TEN) == -1) {
            return n;
        } else {
            return n.mod(BigInteger.TEN).add(digitSum(n.divide(BigInteger.TEN)));
        }
    }

    //Consider the factorial
    private BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }
}
