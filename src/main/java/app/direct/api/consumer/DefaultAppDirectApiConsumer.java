package app.direct.api.consumer;

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
   
    @Value("${api.root.path}")
    private String apiRootPath;

    private final HttpHelper<String> httpHelper;

    @Autowired
    public DefaultAppDirectApiConsumer(HttpHelper<String> httpHelper) {
        this.httpHelper = httpHelper;
    }

    @Override
    public UserResponse userAdd(UserPayLoad user, String companyId) {
        final String payLoad = user.toJson();
        final String path = apiRootPath + "account/v1/companies" + companyId + "/users";
        final ResponseEntity<String> response = httpHelper.doPost(path, payLoad, String.class, null);
        if (!response.getStatusCode().equals(HttpStatus.CREATED)) {
            throw new RuntimeException(response.getBody());
        }
        return SerializerHelper.deserialized(response.getBody(), UserResponse.class);
    }

    @Override
    public CompanyResponse companyAdd(CompanyPayLoad company) {
        final String payLoad = company.toJson();
        final String path = apiRootPath + "account/v1/companies";
        final ResponseEntity<String> response = httpHelper.doPost(path, payLoad, String.class, null);
        if (!response.getStatusCode().equals(HttpStatus.CREATED)) {
            throw new RuntimeException(response.getBody());
        }
        return SerializerHelper.deserialized(response.getBody(), CompanyResponse.class);
    }

    @Override
    public SubscriptionResponse subscriptionAdd(SubscriptionPayload subscription, String companyId, String userId) {
        final String payLoad = subscription.toJson();
        final String path = apiRootPath + "billing/v1/companies/" + companyId + "/users/" + userId + "/subscriptions";
        final ResponseEntity<String> response = httpHelper.doPost(path, payLoad, String.class, null);
        if (!response.getStatusCode().equals(HttpStatus.CREATED)) {
            throw new RuntimeException(response.getBody());
        }
        return SerializerHelper.deserialized(response.getBody(), SubscriptionResponse.class);
    }

    @Override
    public Boolean subscriptionCancel(String subscriptionId) {
        final String path = apiRootPath + "billing/v1/subscriptions/" + subscriptionId;
        final ResponseEntity<String> response = httpHelper.doDelete(path, String.class, null);
        return response.getStatusCode().equals(HttpStatus.NO_CONTENT);
    }
}
