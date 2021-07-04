package com.example.singlescreen.model;

public class APIData {
    String API,Description;

    public APIData() {
    }

    public APIData(String API, String description) {
        this.API = API;
        Description = description;
    }

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
