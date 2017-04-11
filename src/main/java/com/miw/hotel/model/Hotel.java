package com.miw.hotel.model;

public class Hotel {
    private String name;
    private String postalCode;
    private String nameDirector;
    private String lastNameDirector;
    private String image;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getNameDirector() {
        return nameDirector;
    }
    public void setNameDirector(String nameDirector) {
        this.nameDirector = nameDirector;
    }
    public String getLastNameDirector() {
        return lastNameDirector;
    }
    public void setLastNameDirector(String lastNameDirector) {
        this.lastNameDirector = lastNameDirector;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

}
