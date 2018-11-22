package com.umeng.soexample.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class ShopsJsonBean {
    @Id(autoincrement = true)
    private  Long id;
    private  String datas;
    @Generated(hash = 1347963369)
    public ShopsJsonBean(Long id, String datas) {
        this.id = id;
        this.datas = datas;
    }
    @Generated(hash = 431773814)
    public ShopsJsonBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDatas() {
        return this.datas;
    }
    public void setDatas(String datas) {
        this.datas = datas;
    }
    
}
