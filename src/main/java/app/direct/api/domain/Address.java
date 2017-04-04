package app.direct.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Address {
    private String city;
    private String country;
    private String state;
    private String street1;
    private String street2;
    private String zip;

    public Address() {

    }
}
