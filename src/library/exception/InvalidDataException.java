package library.exception;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String messege){
        super(messege);
    }
}
