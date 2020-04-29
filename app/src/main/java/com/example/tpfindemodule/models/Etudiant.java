package com.example.tpfindemodule.models;

import org.json.JSONObject;

public class Etudiant {
    private String firstName;
    private String lastName;
    private String mail;
    private String website;
    private String pictureUrl;


    public Etudiant(JSONObject jsonObject) {
        this.firstName = jsonObject.optString("first_name", "");
        this.lastName = jsonObject.optString("last_name","");
        this.mail = jsonObject.optString("mail", "");
        this.website = jsonObject.optString("website", "");
        this.pictureUrl = jsonObject.optString("picture_url", "");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String prenom) {
        this.firstName = prenom;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String picture_url) {
        this.pictureUrl = picture_url;
    }
}

