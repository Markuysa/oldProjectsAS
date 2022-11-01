package com.example.studentsgeneralkiapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsgeneralkiapp.databinding.AddUserActivityBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlin.properties.Delegates

var counter: Int? = -1
class AddStudentActivity : AppCompatActivity() {

    lateinit var binding:AddUserActivityBinding
    val taskMap: MutableMap<String, Any> = HashMap()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddUserActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.SumbitButton.setOnClickListener {
            val name  = binding.StudentName.text.toString()
            val surname  = binding.StudentSurname.text.toString()
            val room:Int = binding.StudentRoomNumber.text.toString().toInt()
            val course  = binding.StudentCourse.text.toString()
            val Student = StudentStruct(name,surname,room,0,0,0)
            Log.d("MyLog",Student.toString())
            val result = Intent().putExtra(Const.STUDENT_INTENT_KEY,Student)
            setResult(RESULT_OK,result)
            val database =
                Firebase.database("https://dormitoryapp-b4f1a-default-rtdb.europe-west1.firebasedatabase.app")
            Thread {
                val counterRef = database.getReference("Number of students")
                counterRef.addValueEventListener(object: ValueEventListener {

                    override fun onDataChange(snapshot: DataSnapshot) {
                        counter = snapshot.getValue<Int>()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        Log.d("MyLog", "Failed to read value.", error.toException())
                    }

                })
                while (counter==-1) continue
                taskMap["Student $counter"] = Student
                val myRef = database.getReference("Students")
                myRef.updateChildren(taskMap)
                counter = counter?.plus(1)
                counterRef.setValue(counter)
            }.start()
            finish()
        }

    }
}

