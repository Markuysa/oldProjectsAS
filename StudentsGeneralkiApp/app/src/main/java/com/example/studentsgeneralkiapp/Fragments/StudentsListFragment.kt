package com.example.studentsgeneralkiapp.Fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsgeneralkiapp.Adapters.StudentsListAdapter
import com.example.studentsgeneralkiapp.AddStudentActivity
import com.example.studentsgeneralkiapp.Const
import com.example.studentsgeneralkiapp.R
import com.example.studentsgeneralkiapp.StudentStruct
import com.example.studentsgeneralkiapp.databinding.StudentsListFragmentBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentsListFragment : Fragment() {
    lateinit var binding:View
    lateinit var reg:ActivityResultLauncher<Intent>
    val adapter = StudentsListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        reg = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode==RESULT_OK){
                val Student = it.data?.getSerializableExtra(Const.STUDENT_INTENT_KEY) as StudentStruct
                val sruden = it.resultCode
                Log.d("MyLog","asdasdz")
                adapter.onDataChanged(Student)
            }
            else Log.d("MyLog","asdasdz")
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = inflater.inflate(R.layout.students_list_fragment, container, false)
        val view: View = inflater.inflate(R.layout.students_list_fragment, container, false)
        val RCView = view.findViewById<RecyclerView>(R.id.StudentsListRCV)
        val btn = view.findViewById<FloatingActionButton>(R.id.addStudentButton)
        btn.setOnClickListener{
            val intent = Intent(activity,AddStudentActivity::class.java)
            reg.launch(intent)
        }
        RCView.layoutManager = LinearLayoutManager(activity)
        RCView.adapter = adapter
        return view
    }
    companion object {

        @JvmStatic
        fun newInstance() = StudentsListFragment()
    }
}
