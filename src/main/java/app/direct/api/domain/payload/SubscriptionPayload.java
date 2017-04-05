package app.direct.api.domain.payload;

import app.direct.api.domain.Subscription;

public class SubscriptionPayload extends Subscription {

    public SubscriptionPayload() {

    }
    public SubscriptionPayload(Subscription s) {
        setOrder(s.getOrder());
    }
}
