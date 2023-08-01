package com.medicoManager.settingsservice.dto;


public  class UserDto extends AbstractPersonneDto {

    private String username;
    private String kcId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKcId() {
        return kcId;
    }

    public void setKcId(String kcId) {
        this.kcId = kcId;
    }
}
