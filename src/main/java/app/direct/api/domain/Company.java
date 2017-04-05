package app.direct.api.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import app.direct.api.domain.enumeration.Attributes;
import app.direct.api.domain.enumeration.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a company.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonInclude(value = Include.NON_NULL)
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
