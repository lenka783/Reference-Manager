package cz.muni.fi.pa165.referenceManager.service.config;


import cz.muni.fi.pa165.referenceManager.config.PersistenceApplicationContext;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Class representing configuration for the Service layer.
 *
 * @author Lenka Smitalova
 */
@Configuration
@Import(PersistenceApplicationContext.class)
@ComponentScan( basePackages = {
    "cz.muni.fi.pa165.referenceManager.service",
    "cz.muni.fi.pa165.referenceManager.service.facade"})
public class ServiceConfiguration {

    @Bean
    public Mapper dozer(){
        DozerBeanMapper dozer = new DozerBeanMapper();
        return dozer;
    }
}
