package cz.muni.fi.pa165.referenceManager.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for not found resource: 404 NOT FOUND
 *
 * @author Andrej Staruch
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The requested resource was not found")
public class ResourceNotFoundException extends RuntimeException {

}
