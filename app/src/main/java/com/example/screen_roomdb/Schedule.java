package com.example.screen_roomdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Entity of Schedule, data model
/*
    private int id;    //하나의 사용자에 대한 고유 ID값
    private int monday_start;
    private int tuesday_start;
    private int wednesday_start;
    private int thursday_start;
    private int friday_start;
    private int saturday_start;
    private double User2_lat;
    private double User2_long;
*/
@Entity
public class Schedule {
    //참고: 필드를 유지하려면 Room에서 필드에 액세스할 수 있어야 합니다. 필드를 공개하거나 getter 및 setter 메서드를 제공하여 Room에서 필드에 액세스하도록 할 수 있습니다.
    //private로 사용하려면 getter 혹은 setter을 써야한다고 이해함.
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name="day")
    private String day;

    @ColumnInfo(name="departureTime")
    private String departureTime;

    //출발지 lat
    @ColumnInfo(name="User2_lat")
    private double User2_lat;

    //출잘지 long
    @ColumnInfo(name="User2_long")
    private double User2_long;

    //getter, setter (alt+insert)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public double getUser2_lat() {
        return User2_lat;
    }

    public void setUser2_lat(double user2_lat) {
        User2_lat = user2_lat;
    }

    public double getUser2_long() {
        return User2_long;
    }

    public void setUser2_long(double user2_long) {
        User2_long = user2_long;
    }
}
