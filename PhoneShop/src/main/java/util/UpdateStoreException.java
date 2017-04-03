package util;

/**
 * Created by Egor on 29.10.2016.
 */
public class UpdateStoreException extends RuntimeException {
    public UpdateStoreException() {
    }

    public UpdateStoreException(String message) {
        super(message);
    }

    public UpdateStoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateStoreException(Throwable cause) {
        super(cause);
    }

    public UpdateStoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
