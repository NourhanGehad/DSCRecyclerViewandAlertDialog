package com.example.dscrecyclerviewandalertdialog;

public class ImageModel {
    private Integer image;
    private String name;
    private String description = "";

    public ImageModel(Integer image, String name) {
        this.image = image;
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
