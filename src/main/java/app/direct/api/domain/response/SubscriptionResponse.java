package app.direct.api.domain.response;

import app.direct.api.domain.Subscription;

public class SubscriptionResponse extends Subscription {

    public SubscriptionResponse() {

    }

    public SubscriptionResponse(Subscription s) {
        setOrder(s.getOrder());
    }

}
