package com.example.figtoand.model;

public class Refs {
    private int id;
    private String name;
    private String category;
    private String link;
    
    public Refs(String name, String category, String link){
        this.name=name;
        this.category=category;
        this.link = link;
    }
    public Refs(int id, String name, String category, String link){
        this.id=id;
        this.name=name;
        this.category=category;
        this.link = link;
    }
    public Refs(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
