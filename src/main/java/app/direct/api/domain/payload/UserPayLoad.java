package app.direct.api.domain.payload;

import app.direct.api.domain.User;

public class UserPayLoad extends User {
    public UserPayLoad() {

    }
    
    public UserPayLoad(User u){
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
