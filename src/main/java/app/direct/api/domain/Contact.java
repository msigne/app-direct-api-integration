package app.direct.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Contact {

    private Address address;
    private String phoneNumber;
    private String homePhone;
    private String mobilePhone;
    public Contact() {
    }
}
