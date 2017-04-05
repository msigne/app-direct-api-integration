package app.direct.api.domain.payload;

import app.direct.api.domain.Subscription;

/**
 * Represents an Http payload that contain subscription information
 * 
 * @author Martin Blaise Signe.
 */
public class SubscriptionPayload extends Subscription {

    public SubscriptionPayload() {

    }

    public SubscriptionPayload(Subscription s) {
        setOrder(s.getOrder());
    }
}
