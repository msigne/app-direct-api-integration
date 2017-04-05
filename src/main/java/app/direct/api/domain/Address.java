package app.direct.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an address.
 * 
 * @author Martin Blaise Signe.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Address extends Entity{
    private String city;
    private String country;
    private String state;
    private String street1;
    private String street2;
    private String zip;

    public Address() {

    }
}
