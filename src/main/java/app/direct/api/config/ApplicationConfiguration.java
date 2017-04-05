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
    
    /*@Bean
    public OAuth2ProtectedResourceDetails reddit() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setId("reddit");
        details.setClientId(clientID);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setUserAuthorizationUri(userAuthorizationUri);
        details.setTokenName("oauth_token");
        details.setScope(Arrays.asList("identity"));
        details.setPreEstablishedRedirectUri("http://localhost/login");
        details.setUseCurrentUri(false);
        return details;
    }
    
    @Bean
    public OAuth2RestTemplate redditRestTemplate(OAuth2ClientContext clientContext) {
        OAuth2RestTemplate template = new OAuth2RestTemplate(reddit(), clientContext);
        AccessTokenProvider accessTokenProvider = new AccessTokenProviderChain(
          Arrays.<AccessTokenProvider> asList(
            new MyAuthorizationCodeAccessTokenProvider(), 
            new ImplicitAccessTokenProvider(), 
            new ResourceOwnerPasswordAccessTokenProvider(),
            new ClientCredentialsAccessTokenProvider())
        );
        template.setAccessTokenProvider(accessTokenProvider);
        return template;
    }*/
}
