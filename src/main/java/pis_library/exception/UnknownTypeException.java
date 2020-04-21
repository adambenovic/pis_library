package pis_library.exception;

public class UnknownTypeException extends RuntimeException {
    public UnknownTypeException(String type) {
        super("Unknown type " + type);
    }
}
