package app.direct.api.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an order.
 * 
 * @author Martin Blaise Signe.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class Order extends Entity {
    private String paymentPlanId;
    private String discountId;
    private List<OrderLine> orderLines = new ArrayList<>();

    public Order() {
    }
}
