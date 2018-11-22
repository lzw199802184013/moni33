package com.umeng.soexample.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class ShopsBean {
    @Id(autoincrement = true)
    private Long id;
    private String images;
    private  String title;
    private  String price;
    @Generated(hash = 1828702314)
    public ShopsBean(Long id, String images, String title, String price) {
        this.id = id;
        this.images = images;
        this.title = title;
        this.price = price;
    }
    @Generated(hash = 201441839)
    public ShopsBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImages() {
        return this.images;
    }
    public void setImages(String images) {
        this.images = images;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    
}
