package app.direct.api.consumer;

import app.direct.api.domain.payload.CompanyPayLoad;
import app.direct.api.domain.payload.SubscriptionPayload;
import app.direct.api.domain.payload.UserPayLoad;
import app.direct.api.domain.response.CompanyResponse;
import app.direct.api.domain.response.SubscriptionResponse;
import app.direct.api.domain.response.UserResponse;

/**
 * Specify sample API operations that need to be consumed.
 * 
 * @author Martin Blaise Signe.
 */
public interface AppDirectApiConsumer {

    /**
     * Creates a user through the User creation API
     * 
     * @param user
     * @return A userResponse object
     * @see UserResponse
     */
    UserResponse userAdd(UserPayLoad user, String companyId);

    /**
     * Creates a company through the company creation API
     * 
     * @param company
     * @return A companyResponse object.
     * @see CompanyResponse
     */
    CompanyResponse companyAdd(CompanyPayLoad company);

    /**
     * Creates a subscription through the subscription creation API
     * 
     * @param subscription
     * @return A subscriptionResponse object
     * @see SubscriptionResponse
     */
    SubscriptionResponse subscriptionAdd(SubscriptionPayload subscription, String companyId, String userId);

    /**
     * Cancel a subscription through The subscription cancel API
     * 
     * @param subscriptionId Subscription identifier.
     * @return true if the subscription is canceled successfully or false otherwise.
     */
    Boolean subscriptionCancel(String subscriptionId);
}
