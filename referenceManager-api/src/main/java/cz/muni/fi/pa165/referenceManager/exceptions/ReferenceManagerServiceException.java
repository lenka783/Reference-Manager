package cz.muni.fi.pa165.referenceManager.exceptions;

/**
 * Lenka Smitalova
 */
public class ReferenceManagerServiceException extends RuntimeException {

    public ReferenceManagerServiceException() {
        super();
    }

    public ReferenceManagerServiceException(String message) {
        super(message);
    }

    public ReferenceManagerServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReferenceManagerServiceException(Throwable cause) {
        super(cause);
    }
}
