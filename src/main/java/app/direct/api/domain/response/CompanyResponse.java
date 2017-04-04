package app.direct.api.domain.response;

import app.direct.api.domain.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyResponse extends Company {
    private String creationDate;
    
    public CompanyResponse() {
    }
    
    public CompanyResponse(Company c){
        setAddress(c.getAddress());
        setAttributes(c.getAttributes());
        setContact(c.getContact());
        setEmailAddress(c.getEmailAddress());
        setEnabled(c.getEnabled());
        setIndustry(c.getIndustry());
        setName(c.getName());
        setSize(c.getSize());
        setWebsite(c.getWebsite());
    }
 }
