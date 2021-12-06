package com.example.blooddonorv2;

public class Model {
    String blood;
    String name;
    String country;
    String status;
    String contact;

    @Override
    public String toString() {
        return "Model{" +
                "blood='" + blood + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", status='" + status + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public Model(String blood, String name, String country, String status, String contact) {
        this.blood = blood;
        this.name = name;
        this.country = country;
        this.status = status;
        this.contact = contact;
    }

    public Model(String name, String country, String status, String contact) {
        this.name = name;
        this.country = country;
        this.status = status;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
