package com.example.studentsgeneralkiapp.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsgeneralkiapp.R
import com.example.studentsgeneralkiapp.StudentStruct
import com.example.studentsgeneralkiapp.databinding.StudentLayoutBinding

class StudentsListAdapter:RecyclerView.Adapter<StudentsListAdapter.ViewHolder>() {
    var  listOfStudents:MutableList<StudentStruct> = ArrayList()
    class ViewHolder(item: View):RecyclerView.ViewHolder(item) {
        var binding = StudentLayoutBinding.bind(item)
        fun bind(student:StudentStruct){
            val name:String = student.name + " " + student.surname
            binding.apply {
                CourseTextView.text = student.room_number.toString()
                NumberOfFailedCleanings.text=student.countOfFailureCleanings.toString()
                NumberOfSuccessCleanings.text=student.countOfSuccessCleanings.toString()
                RoomNumTextView.text=student.room_number.toString()
                StudentNameTextView.text = name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.student_layout,parent,false))
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfStudents[position])
    }
    override fun getItemCount(): Int {
        return listOfStudents.size
    }
    fun onDataChanged(student:StudentStruct){
        listOfStudents.add(student)
        notifyDataSetChanged()
    }
}