package app.direct.api.domain;

import java.util.ArrayList;
import java.util.List;

import app.direct.api.domain.enumeration.LineType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an Order line.
 * 
 * @author Martin Blaise Signe.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderLine extends Entity {
    private LineType type;
    private Double quantity;
    private Double price;
    private Double percentage;
    private Double totalPrice;
    private String description;
    private List<Parameter> parameters = new ArrayList<>();

    public OrderLine() {

    }
}
