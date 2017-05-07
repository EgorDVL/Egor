package zhyzhko.spring.demo.exceptions;

/**
 * Created by Egor on 07.04.2017.
 */
public class UserCreateException extends RuntimeException {
    private String exceptionMsg;

    public UserCreateException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }
}
