package com.example.mycoscan;

public class Mushroom {
    private String name;
    private String description;
    private String image;
    private boolean isFavorite;

    public Mushroom(String name, String description, String image, boolean isFavorite) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.isFavorite = isFavorite;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIconResource() {
        return image;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}