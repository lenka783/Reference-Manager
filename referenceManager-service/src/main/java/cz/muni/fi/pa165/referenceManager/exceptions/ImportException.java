package cz.muni.fi.pa165.referenceManager.exceptions;

/**
 * @author David Šarman
 */
public class ImportException extends Exception {
    public ImportException(String s) {
        super(s);
    }

    public ImportException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
