package com.example.roomogrencinotteksayfa.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomogrencinotteksayfa.db.entity.StudentEntity

@Dao
interface StudentDAO {

    @Insert
    fun insert(student: StudentEntity)
    @Delete
    fun delete(student: StudentEntity)
    @Query("SELECT*FROM student")
    fun getAllStudent():List<StudentEntity>
}