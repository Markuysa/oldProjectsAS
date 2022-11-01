package com.example.studentsgeneralkiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.studentsgeneralkiapp.Adapters.VpAdapter
import com.example.studentsgeneralkiapp.Fragments.GetRandomStudentsFragment
import com.example.studentsgeneralkiapp.Fragments.StudentsListFragment
import com.example.studentsgeneralkiapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(){
    lateinit var binding:ActivityMainBinding
    private val listofFragments = mutableListOf<Fragment>(
        StudentsListFragment.newInstance(),
        GetRandomStudentsFragment.newInstance()
    )
    private val listofTitles = mutableListOf<String>(
        "Список студентов",
        "Рандомайзер генеральных уборок"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setVP2()


    }
    private fun setVP2(){
        val adapter=VpAdapter(this)
        adapter.getList(listofFragments)
        binding.VP2.adapter=adapter
        TabLayoutMediator(binding.tabLayout,binding.VP2){ tab,position->
            tab.text = listofTitles[position]
        }.attach()

    }

}