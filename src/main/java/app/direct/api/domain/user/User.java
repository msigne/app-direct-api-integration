package app.direct.api.domain.user;

import app.direct.api.domain.enumeration.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import app.direct.api.domain.Address;
import app.direct.api.domain.Contact;
import app.direct.api.domain.Entity;
import app.direct.api.domain.Address.AddressBuilder;
import app.direct.api.domain.enumeration.Title;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class User extends Entity{
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String language;
    private String openId;
    private UserStatus status;
    private String registrationCode;
    private Title title;
    private Contact contact;

    public User() {
    }
}
