package com.umeng.soexample.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.umeng.soexample.greendao.DaoMaster;
import com.umeng.soexample.greendao.ShopsJsonBeanDao;

import java.util.List;

public class ShopsJsonUtils {

    private ShopsJsonBeanDao shopsJsonBeanDao;

    private ShopsJsonUtils() {

    }

    ;
    private static ShopsJsonUtils shopsJsonUtils;

    public static ShopsJsonUtils getShopsJsonUtils() {
        if (shopsJsonUtils == null) {
            shopsJsonUtils = new ShopsJsonUtils();
        }
        return shopsJsonUtils;
    }

    public void init(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "954");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        shopsJsonBeanDao = daoMaster.newSession().getShopsJsonBeanDao();
    }

    //添加
    public void insert(ShopsJsonBean shopsJsonBean) {

        shopsJsonBeanDao.insert(shopsJsonBean);
    }

    //查询
    public List<ShopsJsonBean> query() {
        return shopsJsonBeanDao.loadAll();

    }

    //查询单个
    public ShopsJsonBean queryOne(String key) {

        return shopsJsonBeanDao.load(Long.parseLong(key));
    }

    //删除
    public void delete() {
        shopsJsonBeanDao.deleteAll();
    }

    //删除单个
    public void deleteOne(String key) {

        shopsJsonBeanDao.deleteByKey(Long.parseLong(key));
    }

    //修改
    public void update(ShopsJsonBean shopsJsonBean) {
        shopsJsonBeanDao.update(shopsJsonBean);
    }
}
