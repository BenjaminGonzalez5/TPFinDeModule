package com.example.tpfindemodule.models;

import org.json.JSONObject;

public class Produit {
    private String nom;
    private String description;
    private String url;

    public Produit(JSONObject jsonObject) {
        nom = jsonObject.optString("name", "");
        description = jsonObject.optString("description", "");
        url = jsonObject.optString("picture_url", "");
    }

    public String getName() {
        return nom;
    }

    public void setName(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setPicture_url(String url) {
        this.url = url;
    }
}
