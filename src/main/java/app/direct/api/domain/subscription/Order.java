package app.direct.api.domain.subscription;

import java.util.Collection;

import app.direct.api.domain.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Order extends Entity{
    private String paymentPlanId;
    private String discountId;
    private Collection<OrderLines> orderLines;
    
    public Order(){
        
    }
}
