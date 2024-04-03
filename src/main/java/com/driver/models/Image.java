package com.driver.models;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @JoinColumn
    @ManyToOne
    Blog blog;
    String description;
    String dimension;

    public Image() {

    }

    public Image(String description, String dimension) {
        this.description = description;
        this.dimension = dimension;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimension;
    }

    public void setDimensions(String dimension) {
        this.dimension = dimension;
    }
}