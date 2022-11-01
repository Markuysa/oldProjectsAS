package com.example.studentsgeneralkiapp

import android.os.Parcelable
import java.io.Serializable

data class StudentStruct(val name:String? = null,
                         val surname:String? = null,
                         val room_number:Int?=null,
                         val countOfSuccessCleanings:Int?=null,
                         val countOfFailureCleanings:Int?=null,
                         val courseNumber:Int?=null): Serializable