package com.steven.androidjetpack.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Description:这个组件代表了一个类或者接口作为DAO。DAOs 是Room中的主要组件，并且负责定义访问数据库的方法。
 * 被注解为@Database的类必须包含一个没有参数的抽象方法并且返回注解为@Dao的类。当在编译时生成代码，Room创建一个这个类的实现。
 * Data：9/25/2018-1:27 PM
 *
 * @author yanzhiwen
 */
@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE userName=:name")
    User findByName(String name);

    @Query("SELECT * FROM user WHERE age=:age")
    User findByAge(int age);

    @Query("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert
    void insertAll(List<User> users);

    @Delete
    void delete(User user);
}

