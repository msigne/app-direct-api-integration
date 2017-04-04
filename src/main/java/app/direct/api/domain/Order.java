package app.direct.api.domain;

import java.util.ArrayList;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Order extends Entity{
    private String paymentPlanId;
    private String discountId;
    private Collection<OrderLine> orderLines = new ArrayList<>();
    
    public Order(){        
    }
}
