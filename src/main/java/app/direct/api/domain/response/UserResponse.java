package app.direct.api.domain.response;

import app.direct.api.domain.User;
import app.direct.api.domain.enumeration.Roles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse extends User {
    private String creationDate;
    private String lastSuccessfulLogin;
    private Roles roles;

    public UserResponse() {

    }

    public UserResponse(User u) {
        setContact(u.getContact());
        setEmail(u.getEmail());
        setFirstName(u.getFirstName());
        setId(u.getId());
        setLanguage(u.getLanguage());
        setLanguage(u.getLastName());
        setOpenId(u.getOpenId());
        setRegistrationCode(u.getRegistrationCode());
        setStatus(u.getStatus());
        setTitle(u.getTitle());
    }

}
