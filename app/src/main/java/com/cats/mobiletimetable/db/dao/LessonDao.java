package com.cats.mobiletimetable.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.cats.mobiletimetable.db.relations.LessonWithDetails;
import com.cats.mobiletimetable.db.tables.Lesson;

import java.util.List;

@Dao
public interface LessonDao {

    @Transaction
    @Query("SELECT * FROM lessons;")
    List<LessonWithDetails> getAllLessonsWithDetails();

    @Query("SELECT * FROM lessons;")
    List<Lesson> getAllLessons();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertLesson(Lesson lesson);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    List<Long> insertLesson(Lesson... lessons);

    @Delete
    void deleteLesson(Lesson lesson);

    @Query("DELETE FROM lessons;")
    void deleteAll();
}
