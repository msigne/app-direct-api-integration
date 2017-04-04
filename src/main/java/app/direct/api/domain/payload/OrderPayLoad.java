package app.direct.api.domain.payload;

import app.direct.api.domain.Order;

public class OrderPayLoad extends Order {

    public OrderPayLoad() {

    }

    public OrderPayLoad(Order o) {
        setDiscountId(o.getDiscountId());
        setOrderLines(o.getOrderLines());
        setPaymentPlanId(o.getPaymentPlanId());
    }

}
