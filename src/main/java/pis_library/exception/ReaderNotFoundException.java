package pis_library.exception;

public class ReaderNotFoundException extends RuntimeException {
    public ReaderNotFoundException(Long id) {
        super("Couldn't find reader id " + id);
    }
}
