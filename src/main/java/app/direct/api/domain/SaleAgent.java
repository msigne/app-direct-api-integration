package app.direct.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a Sale agent.
 * 
 * @author Martin Blaise Signe.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class SaleAgent extends Entity {

    private String id;
    private String href;

    public SaleAgent() {

    }
}
