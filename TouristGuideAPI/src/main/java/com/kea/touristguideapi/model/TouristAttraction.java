package com.kea.touristguideapi.model;

public class TouristAttraction {
    private String name;
    private String description;

    public TouristAttraction(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //getters
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    //setters
    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String name) {
        this.name = name;
    }
}
