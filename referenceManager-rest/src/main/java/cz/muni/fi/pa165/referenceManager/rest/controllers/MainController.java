package cz.muni.fi.pa165.referenceManager.rest.controllers;

import cz.muni.fi.pa165.referenceManager.rest.ApiUris;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andrej Staruch
 */

@RestController
public class MainController {

    final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public final Map<String, String> getResources() {
        Map<String,String> resourcesMap = new HashMap<>();

        resourcesMap.put("notes_uri", ApiUris.ROOT_URI_NOTES);
        resourcesMap.put("references_uri", ApiUris.ROOT_URI_REFERENCES);
        resourcesMap.put("tags_uri", ApiUris.ROOT_URI_TAGS);
        resourcesMap.put("users_uri", ApiUris.ROOT_URI_USERS);

        return Collections.unmodifiableMap(resourcesMap);

    }
}
