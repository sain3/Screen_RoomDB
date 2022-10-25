package com.example.screen_roomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//Dao of Schedule
@Dao
public interface ScheduleDao {

    @Insert //삽입
    void setInsertSchedule(Schedule schedule);

    //전부 삽입
    @Insert
    void insertAll(Schedule... schedules);

    //삭제
    @Delete
    void delete(Schedule schedule);

    //수정
    @Update
    public void updateSchedule(Schedule... schedules);

    //단순한 쿼리: 전부 가져오기
    @Query("SELECT * FROM schedule")
    List<Schedule> getAll();

    /*
    -- 특정 행 특정 열 조회하기 --
    SELECT [열1, 열2, ...] FROM [테이블명] WHERE [행 선택 조건식]
    */

    //요일의 출발시간 가져오기 *테스트 필요
    @Query("SELECT departureTime FROM schedule WHERE day = (:day)")
    String timeOfDay(String day);

    //요일의 출발시간, 위치 가져오기 *테스트 필요: 현재 이 코드는 컴파일시 오류 발생 데이터 타입 문제인듯
    /*
    @Query("SELECT departureTime, User2_lat, User2_long FROM schedule WHERE day = (:day)")
    List<Schedule> DataOfDay(String day);
    //day를 제외한 나머지를 출력하는 것도 괜찮을 거 같음
    */

    /* 개념 설계
    테이블이 공유하는 데이터들의 키 컬럼은 id, day, depatureTime, lat, long 이다.
    */
    /* 샘플
    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);
    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
           "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);
    @Insert
    void insertAll(User... users);
    @Delete
    void delete(User user);
    */
}