package com.example.roomogrencinotteksayfa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomogrencinotteksayfa.databinding.ActivityMainBinding
import com.example.roomogrencinotteksayfa.db.StudentDatabase
import com.example.roomogrencinotteksayfa.db.entity.StudentEntity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentDatabase= StudentDatabase.getStudentDatabase(this)

        binding.btnSave.setOnClickListener {
            val name=binding.etStudentName.text.toString()
            val grade=Integer.valueOf(binding.etStudentGrade.text.toString())

            val student= StudentEntity(studentName = name,studentGrade = grade)
            studentDatabase?.studentDao()?.insert(student)
        }

        binding.btnAllStudents.setOnClickListener {
            var result=""

            val students:ArrayList<StudentEntity> = studentDatabase?.studentDao()?.getAllStudent() as ArrayList<StudentEntity>

            students.forEach{
                result+=it.studentName+"->"+it.studentGrade+"\n"
            }
            binding.tvResult.text=result
        }
    }
}