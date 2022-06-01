package com.example.roomogrencinotteksayfa.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomogrencinotteksayfa.db.entity.StudentEntity
import com.example.roomogrencinotteksayfa.db.dao.StudentDAO

@Database(entities = [StudentEntity::class],version = 1)
abstract class StudentDatabase:RoomDatabase() {

    abstract fun studentDao(): StudentDAO
    companion object {
        private var instance: StudentDatabase? = null

        fun getStudentDatabase(context: Context): StudentDatabase? {

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    StudentDatabase::class.java,
                    "student.db"
                ).allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}
