package cz.muni.fi.pa165.referenceManager.exceptions;

public class ExportException extends Exception {
    public ExportException(String s) {
        super(s);
    }

    public ExportException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
