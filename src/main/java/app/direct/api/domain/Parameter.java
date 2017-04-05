package app.direct.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a Parameter.
 * 
 * @author Martin Blaise Signe.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Parameter extends Entity {

    private String name;
    private String value;

    public Parameter() {

    }
}
