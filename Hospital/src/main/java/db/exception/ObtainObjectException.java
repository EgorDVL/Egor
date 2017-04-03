package db.exception;

/**
 * Created by Egor on 06.01.2017.
 */
public class ObtainObjectException extends RuntimeException {

    public ObtainObjectException() {
    }

    public ObtainObjectException(String message) {
        super(message);
    }

    public ObtainObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObtainObjectException(Throwable cause) {
        super(cause);
    }

    public ObtainObjectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
