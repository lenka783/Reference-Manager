package cz.muni.fi.pa165.referenceManager.rest;

/**
 * Represents the entry points for the API
 * this list can be increased so that it contains all the
 * other URIs also for the sub-resources so that it can
 * reused globally from all the controllers
 *
 * @author Andrej Staruch
 */
public abstract class ApiUris {
    public static final String ROOT_URI_NOTES = "/notes";
    public static final String ROOT_URI_REFERENCES = "/references";
    public static final String ROOT_URI_TAGS = "/tags";
    public static final String ROOT_URI_USERS = "/users";
}
