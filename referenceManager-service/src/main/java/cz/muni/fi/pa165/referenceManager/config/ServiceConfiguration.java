package cz.muni.fi.pa165.referenceManager.config;


import cz.muni.fi.pa165.referenceManager.config.PersistenceApplicationContext;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;

/**
 * Class representing configuration for the Service layer.
 *
 * @author Lenka Smitalova
 */
@Configuration
@Import(PersistenceApplicationContext.class)
@ComponentScan( basePackages = {
    "cz.muni.fi.pa165.referenceManager.service",
    "cz.muni.fi.pa165.referenceManager.facade"})
public class ServiceConfiguration {

    @Bean
    public Mapper dozer(){
        return new DozerBeanMapper();
    }

    @Bean
    public PasswordEncryptor encryptor(){
        return new ConfigurablePasswordEncryptor();
    }
}
