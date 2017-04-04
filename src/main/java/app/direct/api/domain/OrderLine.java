package app.direct.api.domain;

import java.util.ArrayList;
import java.util.Collection;

import app.direct.api.domain.enumeration.LineType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class OrderLine {
    private LineType type;
    private Double quantity;
    private Double price;
    private Double percentage;
    private Double totalPrice;
    private String description;
    private Collection<Parameter> parameters = new ArrayList<>();

    public OrderLine() {

    }
}
