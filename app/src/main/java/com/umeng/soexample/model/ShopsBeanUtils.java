package com.umeng.soexample.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.umeng.soexample.greendao.DaoMaster;
import com.umeng.soexample.greendao.ShopsBeanDao;

import java.util.List;

public class ShopsBeanUtils {

    private ShopsBeanDao shopsBeanDao;

    private ShopsBeanUtils() {

    }

    ;
    private static ShopsBeanUtils shopsBeanUtils;

    public static ShopsBeanUtils getShopsBeanUtils() {
        if (shopsBeanUtils == null) {
            shopsBeanUtils = new ShopsBeanUtils();
        }
        return shopsBeanUtils;

    }

    public void init(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "lll");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        shopsBeanDao = daoMaster.newSession().getShopsBeanDao();
    }

    //添加
    public void insert(ShopsBean shopsBean) {
        shopsBeanDao.insert(shopsBean);
    }

    //查询
    public List<ShopsBean> query() {
        return shopsBeanDao.loadAll();
    }

    //删除
    public void delete() {

        shopsBeanDao.deleteAll();

    }

    //查询单个
    public ShopsBean queryOne(String key) {

        return shopsBeanDao.load(Long.parseLong(key));
    }

    //删除单个
    public void deleteOne(String key) {
        shopsBeanDao.deleteByKey(Long.parseLong(key));
    }

    //修改
    public void update(ShopsBean shopsBean) {
        shopsBeanDao.update(shopsBean);
    }
}
