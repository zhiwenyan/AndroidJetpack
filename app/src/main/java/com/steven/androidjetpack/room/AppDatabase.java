package com.steven.androidjetpack.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

import java.util.List;

/**
 * Description:你可以使用这个组件创建一个数据库holder。注解定义了一系列entities并且类的内容提供了一系列DAOs，它也是下层的主要连接 的访问点。
 * 注解的类应该是一个抽象的继承 RoomDatabase的类。在运行时，你能获得一个实例通过调用Room.databaseBuilder()或者 Room.inMemoryDatabaseBuilder()
 * Data：9/25/2018-1:30 PM
 *
 * @author yanzhiwen
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String TAG = AppDatabase.class.getSimpleName();
    private static volatile AppDatabase sInstance;

    @VisibleForTesting
    private static final String DATABASE_NAME = "basic-sample-db";

    public abstract UserDao userDao();


    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDataBase(context, executors);
                }
            }

        }
        return sInstance;
    }

    private static AppDatabase buildDataBase(final Context context, final AppExecutors executors) {
        //创建数据库
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        //创建数据库的时候个调用
                        executors.diskIO().execute(() -> {
                            List<User> users = UserGenerator.generateUser();
                            AppDatabase appDatabase = AppDatabase.getInstance(context, executors);
                            insertData(appDatabase, users);
                        });
                    }
                }).build();

    }

    private static void insertData(final AppDatabase database, final List<User> users) {
        database.runInTransaction(() -> {
            database.userDao().insertAll(users);
            Log.e(TAG, "insert data success");
        });
    }

}
