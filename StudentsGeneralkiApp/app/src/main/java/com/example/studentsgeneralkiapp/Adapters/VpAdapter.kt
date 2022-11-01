package com.example.studentsgeneralkiapp.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class VpAdapter(fragment:FragmentActivity):FragmentStateAdapter(fragment) {
    var FragmentsList:MutableList<Fragment> = ArrayList()
    override fun getItemCount(): Int = FragmentsList.size
    fun getList(fragment : MutableList<Fragment> ){ FragmentsList = fragment }
    override fun createFragment(position: Int): Fragment = FragmentsList[position]
}