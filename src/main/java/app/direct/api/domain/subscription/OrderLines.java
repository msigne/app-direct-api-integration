package app.direct.api.domain.subscription;

import java.util.Collection;

import app.direct.api.domain.enumeration.LineType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OrderLines {
    private LineType type;
    private Double quantity;
    private Double price;
    private Double percentage;
    private Double totalPrice;
    private String description;
    private Collection<Parameter> parameters;
    
    public OrderLines(){
        
    }
    
}
