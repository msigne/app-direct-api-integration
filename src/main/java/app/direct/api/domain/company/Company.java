package app.direct.api.domain.company;

import app.direct.api.domain.Address;
import app.direct.api.domain.Contact;
import app.direct.api.domain.Entity;
import app.direct.api.domain.enumeration.Attributes;
import app.direct.api.domain.enumeration.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Company extends Entity {
    private String name;
    private Boolean enabled;
    private Size size;
    private String emailAddress;
    private Address address;
    private Contact contact;
    private String website;
    private String industry;
    private Attributes attributes;

    public Company() {

    }
}
