package cz.muni.fi.pa165.referenceManager.sampleData;

import java.io.IOException;

/**
 * Fill the database with sample data used for representing the web-app.
 *
 * @author Lenka Smitalova
 */
public interface SampleDataLoadingFacade {

    /**
     * Method for loading example data into the database.
     */
    void loadData();
}
