package exception;

public class DivideByZero extends IllegalArgumentException {

    public DivideByZero() {
    }

    public DivideByZero(String s) {
        super(s);
    }

    public DivideByZero(String message, Throwable cause) {
        super(message, cause);
    }

    public DivideByZero(Throwable cause) {
        super(cause);
    }
}
