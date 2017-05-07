package db.exception;

/**
 * Created by Egor on 12.01.2017.
 */
public class MailSandingException extends RuntimeException {
    public MailSandingException() {
    }

    public MailSandingException(String message) {
        super(message);
    }

    public MailSandingException(String message, Throwable cause) {
        super(message, cause);
    }

    public MailSandingException(Throwable cause) {
        super(cause);
    }

    public MailSandingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
