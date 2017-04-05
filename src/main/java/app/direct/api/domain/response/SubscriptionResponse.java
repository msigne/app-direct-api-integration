package app.direct.api.domain.response;

import app.direct.api.domain.Subscription;

/**
 * Represents an Http response body that contain subscription information
 * 
 * @author Martin Blaise Signe.
 */
public class SubscriptionResponse extends Subscription {

    public SubscriptionResponse() {

    }

    public SubscriptionResponse(Subscription s) {
        setOrder(s.getOrder());
    }

}
