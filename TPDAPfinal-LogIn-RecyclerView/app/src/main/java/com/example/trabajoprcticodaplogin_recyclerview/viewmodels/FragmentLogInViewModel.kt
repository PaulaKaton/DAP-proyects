package com.example.trabajoprcticodaplogin_recyclerview.viewmodels

import androidx.lifecycle.ViewModel
import com.example.trabajoprcticodaplogin_recyclerview.entities.Users

class FragmentLogInViewModel : ViewModel() {
    var usersList: MutableList<Users> = mutableListOf()
}