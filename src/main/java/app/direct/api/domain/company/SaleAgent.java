package app.direct.api.domain.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SaleAgent {

    private String id;
    private String href;

    public SaleAgent() {

    }
}
