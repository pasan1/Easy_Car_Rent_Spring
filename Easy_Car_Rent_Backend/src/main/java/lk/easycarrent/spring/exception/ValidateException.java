package lk.easycarrent.spring.exception;

public class ValidateException extends RuntimeException{
    public ValidateException(String message) {
        super(message);
    }
}
