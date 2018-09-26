package com.steven.androidjetpack.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Description:实体类
 * Data：9/25/2018-1:25 PM
 *
 * @author yanzhiwen
 */
@Entity(tableName = "user")
public class User {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "userName")
    private String userName;

    @ColumnInfo(name = "age")
    private int age;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
