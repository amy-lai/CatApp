package com.example.catapp;
import com.google.gson.annotations.SerializedName;

public class Cat {
    private String id;
    private String name;
    private String description;

//    @SerializedName("metric")
//    private String catWeight;
//
//    private String temperament;
//    private String origin;
//    private String life_span;
//    private String wikipedia_url;
//    private int dog_friendly;

//    @SerializedName("url")
//    private String catImage;

    public Cat(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
//
//    public String getCatWeight() {
//        return catWeight;
//    }
//
//    public void setCatWeight(String catWeight) {
//        this.catWeight = catWeight;
//    }
//
//    public String getTemperament() {
//        return temperament;
//    }
//
//    public void setTemperament(String temperament) {
//        this.temperament = temperament;
//    }
//
//    public String getOrigin() {
//        return origin;
//    }
//
//    public void setOrigin(String origin) {
//        this.origin = origin;
//    }
//
//    public String getLife_span() {
//        return life_span;
//    }
//
//    public void setLife_span(String life_span) {
//        this.life_span = life_span;
//    }
//
//    public String getWikipedia_url() {
//        return wikipedia_url;
//    }
//
//    public void setWikipedia_url(String wikipedia_url) {
//        this.wikipedia_url = wikipedia_url;
//    }
//
//    public int getDog_friendly() {
//        return dog_friendly;
//    }
//
//    public void setDog_friendly(int dog_friendly) {
//        this.dog_friendly = dog_friendly;
//    }

//    public String getCatImage() {
//        return catImage;
//    }
//
//    public void setCatImage(String catImage) {
//        this.catImage = catImage;
//    }
}
