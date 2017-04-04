package app.direct.api.domain.subscription;

import app.direct.api.domain.enumeration.OrderStatus;
import lombok.Data;

@Data
public class OrderResponse extends Order {
    private String id;
    private String creationDate;
    private String endDate;
    private OrderStatus status;
    private Long maxUsers;

    public OrderResponse() {

    }
}
