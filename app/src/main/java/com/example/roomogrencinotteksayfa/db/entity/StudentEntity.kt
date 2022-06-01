package com.example.roomogrencinotteksayfa.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class StudentEntity(
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name="studentId")
    var studentId:Int=0,

    @ColumnInfo(name = "studentName")
    var studentName:String,

    @ColumnInfo(name = "studentGrade")
    var studentGrade:Int
    )


