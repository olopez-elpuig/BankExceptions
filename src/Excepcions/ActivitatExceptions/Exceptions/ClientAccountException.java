package Excepcions.ActivitatExceptions.Exceptions;

public class ClientAccountException extends Exception {

    public ClientAccountException(String s) {
        super(s);
    }

    public ClientAccountException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ClientAccountException(Throwable throwable) {
        super(throwable);
    }
}