package com.bai.myapplication.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  kingsley on 2019/5/7 0007.
 */

public class DBserver {
    private mySql mySql;

    public DBserver(Context context) {
        mySql = new mySql(context);
    }

    public void addUser(UserInfoEntity entity) {
        SQLiteDatabase sqLiteDatabase = this.mySql.getWritableDatabase();
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = entity.getId();
        arrayOfObject[1] = entity.getName();
        arrayOfObject[2] = entity.getAge();
        arrayOfObject[3] = entity.getSex();
        sqLiteDatabase.execSQL("insert into jin (id,name,age,sex)values(?,?,?,?)", arrayOfObject);
        sqLiteDatabase.close();
    }

    public List<UserInfoEntity> findAllUser() {
        List<UserInfoEntity> allEntity = new ArrayList<UserInfoEntity>();
        SQLiteDatabase sqLiteDatabase = this.mySql.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from jin where 1=1 order by age asc", null);
        while (cursor.moveToNext()) {
            UserInfoEntity entity = new UserInfoEntity();
            entity.setId(cursor.getString(cursor.getColumnIndex("id")));
            entity.setName(cursor.getString(cursor.getColumnIndex("name")));
            entity.setAge(cursor.getString(cursor.getColumnIndex("age")));
            entity.setSex(cursor.getString(cursor.getColumnIndex("sex")));
            allEntity.add(entity);
        }
        sqLiteDatabase.close();
        return allEntity;
    }
}
