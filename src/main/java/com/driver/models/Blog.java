package com.driver.models;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @JoinColumn
    @ManyToOne
    User user;
    String title;
    String content;
    Date pub;
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    List<Image> imageList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> x) {
        this.imageList = x;
    }

    public Date getPubDate() {
        return pub;
    }

    public void setPubDate(Date pub) {
        this.pub = pub;
    }

    public Blog() {
        imageList = new ArrayList<>();
    }

    public Blog(String title, String content) {
        this.content = content;
        this.title = title;
        imageList = new ArrayList<>();
    }
}