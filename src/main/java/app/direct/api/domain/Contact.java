package app.direct.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a contact.
 * 
 * @author Martin Blaise Signe.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Contact extends Entity {

    private Address address;
    private String phoneNumber;
    private String homePhone;
    private String mobilePhone;

    public Contact() {
    }
}
