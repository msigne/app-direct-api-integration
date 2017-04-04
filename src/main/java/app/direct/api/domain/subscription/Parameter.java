package app.direct.api.domain.subscription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Parameter {

    private String name;
    private String value;
    
    public Parameter(){
        
    }
}
