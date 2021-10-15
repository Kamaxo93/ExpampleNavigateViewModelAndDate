package com.example.expamplenavigateviewmodel

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.parcelize.Parcelize

class MainViewModel : ViewModel() {

    private val users = MutableLiveData<User>()

     fun setUser(user: User) {
         this.users.value = user
     }

    fun getUser() = users

}

@Parcelize
data class User(val name: String, val age: Int) : Parcelable