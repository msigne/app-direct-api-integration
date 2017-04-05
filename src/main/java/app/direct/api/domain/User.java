package app.direct.api.domain;

import app.direct.api.domain.enumeration.Title;
import app.direct.api.domain.enumeration.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a user.
 * 
 * @author Martin Blaise Signe.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User extends Entity {
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
