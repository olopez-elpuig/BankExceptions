package Excepcions.ActivitatExceptions.Exceptions;

public class BankAccountException extends Exception {

    public BankAccountException(String s) {
        super(s);
    }

    public BankAccountException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BankAccountException(Throwable throwable) {
        super(throwable);
    }
}