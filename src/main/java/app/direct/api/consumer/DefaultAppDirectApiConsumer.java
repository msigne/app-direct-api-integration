package app.direct.api.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import app.direct.api.domain.payload.CompanyPayLoad;
import app.direct.api.domain.payload.SubscriptionPayload;
import app.direct.api.domain.payload.UserPayLoad;
import app.direct.api.domain.response.CompanyResponse;
import app.direct.api.domain.response.SubscriptionResponse;
import app.direct.api.domain.response.UserResponse;
import app.direct.api.helper.HttpHelper;
import app.direct.api.helper.SerializerHelper;

/**
 * Default implementation of the AppDirectApiConsumer interface.
 * 
 * @author Martin Blaise Signe.
 */
@Component
public class DefaultAppDirectApiConsumer implements AppDirectApiConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAppDirectApiConsumer.class);

    @Value("${api.root.path}")
    private String apiRootPath;

    private final HttpHelper httpHelper;

    @Autowired
    public DefaultAppDirectApiConsumer(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    @Override
    public UserResponse userAdd(UserPayLoad user, String companyId) {
        final String payLoad = user.toJson();
        final String path = apiRootPath + "account/v1/companies" + companyId + "/users";
        LOGGER.info("Request to process recieved. url={}. body={}", payLoad, path);
        final ResponseEntity<String> response = httpHelper.doPost(path, payLoad);
        if (!response.getStatusCode().equals(HttpStatus.CREATED)) {
            LOGGER.error("Failed to add the user. status ={}. response={}", response.getStatusCodeValue(), response.getBody());
            throw new RuntimeException(response.getStatusCodeValue() + " - " + response.getBody());
        }
        LOGGER.info("Request successfully proced recieved. status={}. response={}", response.getStatusCodeValue(), response.getBody());
        return SerializerHelper.deserialized(response.getBody(), UserResponse.class);
    }

    @Override
    public CompanyResponse companyAdd(CompanyPayLoad company) {
        final String payLoad = company.toJson();
        final String path = apiRootPath + "account/v1/companies";
        LOGGER.info("Request to process recieved. url={}. body={}", payLoad, path);
        final ResponseEntity<String> response = httpHelper.doPost(path, payLoad);
        if (!response.getStatusCode().equals(HttpStatus.CREATED)) {
            LOGGER.error("Failed to add the company. status ={}. response={}", response.getStatusCodeValue(), response.getBody());
            throw new RuntimeException(response.getStatusCodeValue() + " - " + response.getBody());
        }
        LOGGER.info("Request successfully proced recieved. status={}. response={}", response.getStatusCodeValue(), response.getBody());
        return SerializerHelper.deserialized(response.getBody(), CompanyResponse.class);
    }

    @Override
    public SubscriptionResponse subscriptionAdd(SubscriptionPayload subscription, String companyId, String userId) {
        final String payLoad = subscription.toJson();
        final String path = apiRootPath + "billing/v1/companies/" + companyId + "/users/" + userId + "/subscriptions";
        LOGGER.info("Request to process recieved. url={}. body={}", payLoad, path);
        final ResponseEntity<String> response = httpHelper.doPost(path, payLoad);
        if (!response.getStatusCode().equals(HttpStatus.CREATED)) {
            LOGGER.error("Failed to add the subscription. status ={}. response={}", response.getStatusCodeValue(), response.getBody());
            throw new RuntimeException(response.getStatusCodeValue() + " - " + response.getBody());
        }
        LOGGER.info("Request successfully proced recieved. status={}. response={}", response.getStatusCodeValue(), response.getBody());
        return SerializerHelper.deserialized(response.getBody(), SubscriptionResponse.class);
    }

    @Override
    public Boolean subscriptionCancel(String subscriptionId) {
        final String path = apiRootPath + "billing/v1/subscriptions/" + subscriptionId;
        LOGGER.info("Request to process recieved. url={}", path);
        final ResponseEntity<String> response = httpHelper.doDelete(path);
        LOGGER.info("Request successfully proced recieved. status={}. response={}", response.getStatusCodeValue(), response.getBody());
        return response.getStatusCode().equals(HttpStatus.NO_CONTENT);
    }
}
