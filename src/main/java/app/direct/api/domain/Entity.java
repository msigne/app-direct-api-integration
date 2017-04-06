package app.direct.api.domain;

import app.direct.api.helper.SerializerHelper;
import lombok.Data;

/**
 * Generic domain object that all domain extend.
 * 
 * @author Martin Blaise Signe.
 */
@Data
public abstract class Entity {
    private String id;

    /**
     * Built a JSON representation of the current entity.
     * 
     * @return A string that represents a JSON value for the current object.
     */
    public String toJson() {
        return SerializerHelper.toJson(this);
    }
}
