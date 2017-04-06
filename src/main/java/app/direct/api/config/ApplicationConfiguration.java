package app.direct.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Global Spring configuration.
 * 
 * @author Martin Blaise Signe
 */
@ComponentScan(basePackages = {ApplicationConfiguration.COMPONENT_BASE_PACKAGE})
@Configuration
@EnableOAuth2Client
public class ApplicationConfiguration {

    public final static String COMPONENT_BASE_PACKAGE = "app.direct.api";
    
    @Value("${api.auth.token.url}")
    private String tokenUrl;

    @Value("${api.auth.token.consumer.secret}")
    private String consumerSecret;

    @Value("${api.auth.token.consumer.key}")
    private String consumerKey;

    @Bean
    protected OAuth2ProtectedResourceDetails resource() {
        final ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();
        resource.setAccessTokenUri(tokenUrl);
        resource.setClientId(consumerKey);
        resource.setClientSecret(consumerSecret);
        return resource;
    }

    @Bean
    public OAuth2RestOperations restTemplate(OAuth2ProtectedResourceDetails resource) {
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        return new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext(atr));
    }
}
