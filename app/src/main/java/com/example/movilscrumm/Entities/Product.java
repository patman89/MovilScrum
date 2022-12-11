package com.example.movilscrumm.Entities;

public class Product {
    private String id;
    private int image;
    private String name;
    private String description;
    private String price;

    public Product(int image, String name, String description, String price) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public Product( String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}