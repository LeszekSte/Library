package library.exception;

public class NoSuchFileTypeException extends RuntimeException {
    public NoSuchFileTypeException(String messege){
        super(messege);
    }
}
