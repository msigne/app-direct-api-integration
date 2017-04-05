package app.direct.api.domain.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import app.direct.api.domain.Company;

@JsonInclude(value=Include.NON_NULL)
public class CompanyPayLoad extends Company {

    public CompanyPayLoad() {

    }

    public CompanyPayLoad(Company c) {
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
