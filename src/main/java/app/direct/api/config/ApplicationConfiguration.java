package app.direct.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Global Spring configuration.
 * 
 * @author Martin Blaise Signe
 */
@ComponentScan(basePackages = {ApplicationConfiguration.COMPONENT_BASE_PACKAGE})
@Configuration
public class ApplicationConfiguration {

    public final static String COMPONENT_BASE_PACKAGE = "app.direct.api";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
