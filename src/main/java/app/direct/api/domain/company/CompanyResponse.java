package app.direct.api.domain.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompanyResponse extends Company {
    private String creationDate;
    
    public CompanyResponse() {

    }
}
