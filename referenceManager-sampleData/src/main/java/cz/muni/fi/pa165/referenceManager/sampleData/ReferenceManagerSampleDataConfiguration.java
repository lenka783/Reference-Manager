package cz.muni.fi.pa165.referenceManager.sampleData;

import cz.muni.fi.pa165.referenceManager.config.ServiceConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

/**
 * Takes ServiceConfiguration and adds the SampleDataLoading bean into it.
 *
 */
@Configuration
@Import(ServiceConfiguration.class)
@ComponentScan(basePackageClasses = SampleDataLoadingFacadeImpl.class)
public class ReferenceManagerSampleDataConfiguration {

    final static Logger log = LoggerFactory.getLogger(ReferenceManagerSampleDataConfiguration.class);

    @Autowired
    SampleDataLoadingFacade sampleDataLoadingFacade;

    @PostConstruct
    public void dataLoading() {
        log.debug("Loading sample data.");
        sampleDataLoadingFacade.loadData();
    }
}
