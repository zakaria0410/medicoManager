package com.medicoManager.settingsservice.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


public class AbstractNameSettingsDto extends BaseDTO {

private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public AbstractNameSettingsDto() {
        super();
    }
*/

// Getters and setters for name

    // Other properties and methods for all name settings DTOs
}
