package app.direct.api.config.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "swagger.service")
@Data
public class SwaggerProperties {

    private String title;
    private String description;
    private String termOfUseUrl;
    private String licence;
    private String licenceUrl;
    private String version;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
}
