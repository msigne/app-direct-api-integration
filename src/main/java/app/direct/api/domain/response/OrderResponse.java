package app.direct.api.domain.response;

import app.direct.api.domain.Order;
import app.direct.api.domain.enumeration.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse extends Order {
    private String id;
    private String creationDate;
    private String endDate;
    private OrderStatus status;
    private Long maxUsers;

    public OrderResponse() {

    }
    
    public OrderResponse(Order o) {
        setDiscountId(o.getDiscountId());
        setOrderLines(o.getOrderLines());
        setPaymentPlanId(o.getPaymentPlanId());
    }
}
