package app.direct.api.domain.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import app.direct.api.domain.User;

/**
 * Represents an Http payload that contain user information
 * 
 * @author Martin Blaise Signe.
 */
@JsonInclude(value = Include.NON_NULL)
public class UserPayLoad extends User {
    public UserPayLoad() {

    }

    public UserPayLoad(User u) {
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
