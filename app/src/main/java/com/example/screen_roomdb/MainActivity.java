package com.example.screen_roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import androidx.loader.content.AsyncTaskLoader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
//import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ScheduleDao scheduleDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Room이라고 치고 alt+enter로 dependency에 room libaray_runtime import

        ScheduleDB scheduleDB = Room.databaseBuilder(getApplicationContext(), ScheduleDB.class, "Screen")
                .fallbackToDestructiveMigration() // 스키마 버전 변경 가능
                .allowMainThreadQueries() // Main Thread에서 dB에 입출력을 가능하게 함. 이거를 서브스레드에서 사용하도록 변경해야할거같음
                .build();

        scheduleDao = scheduleDB.scheduleDao(); // 인터페이스 객체 할당

        // 데이터 삽입
        Schedule schedule = new Schedule(); // 객체 인스턴스 생성
        schedule.setDay("금요일");
        schedule.setDepartureTime("1시 10분");

        scheduleDao.setInsertSchedule(schedule);
    }
}