package com.example.studentsgeneralkiapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.studentsgeneralkiapp.R
class GetRandomStudentsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_random_students, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = GetRandomStudentsFragment()
            }
    }
