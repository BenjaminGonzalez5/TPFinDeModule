package com.example.tpfindemodule.models;

import org.json.JSONObject;

public class Categorie {
    private String id = "";
    private String titre = "";
    private String url = "";

    public Categorie(JSONObject jsonObject) {
        id = jsonObject.optString("category_id", "");
        titre = jsonObject.optString("title", "");
        url = jsonObject.optString("products_url", "");
        url = getUrl().replace("http", "https");
    }


    public String getCategoryId() {
        return id;
    }

    public void setCategoryId(String category_id) {
        this.id = category_id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
