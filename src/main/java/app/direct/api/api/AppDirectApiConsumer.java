package app.direct.api.api;

import app.direct.api.domain.payload.CompanyPayLoad;
import app.direct.api.domain.payload.SubscriptionPayload;
import app.direct.api.domain.payload.UserPayLoad;
import app.direct.api.domain.response.CompanyResponse;
import app.direct.api.domain.response.SubscriptionResponse;
import app.direct.api.domain.response.UserResponse;

public interface AppDirectApiConsumer {

    /**
     * 
     * @param user
     * @return
     */
    UserResponse userAdd(UserPayLoad user, String companyId);

    /**
     * 
     * @param company
     * @return
     */
    CompanyResponse companyAdd(CompanyPayLoad company);

    /**
     * 
     * @param subscription
     * @return
     */
    SubscriptionResponse subscriptionAdd(SubscriptionPayload subscription, String companyId, String userId);

    /**
     * 
     * @param subscriptionId
     */
    Boolean subscriptionDelete(String subscriptionId);
}
