package com.example.screen_roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//ScheduleDb
@Database(entities = {Schedule.class}, version = 1)
public abstract class ScheduleDB extends RoomDatabase {
    private static ScheduleDB INSTANCE = null;
    public abstract ScheduleDao scheduleDao();

    public static ScheduleDB getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    ScheduleDB.class, "Schedule.db").build();
        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }
}