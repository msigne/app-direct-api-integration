package app.direct.api.domain.user;

import app.direct.api.domain.enumeration.Roles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse extends User {
    private String creationDate;
    private String lastSuccessfulLogin;
    private Roles roles;
    
    public UserResponse(){
        
    }
}
