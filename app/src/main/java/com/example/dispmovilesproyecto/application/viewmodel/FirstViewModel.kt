package com.example.dispmovilesproyecto.application.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dispmovilesproyecto.application.login.usercases.SaveUserUC
import com.example.dispmovilesproyecto.data.remote.dto.UserDtoRemote
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext


class FirstViewModel : ViewModel() {

    val counterUI
        get() = _counterUI

    private var _counterUI = MutableLiveData<Int>()

    val userRemote get() = _userRemote

    private var _userRemote = MutableLiveData<UserDtoRemote>()

    fun contador(){

        viewModelScope.launch {
            var counter: Int = 0

            for (i in 1..10) {
                delay(1000)
                counter++
                _counterUI.value = counter
            }
        }
    }


    fun guardarUsuario(user: UserDtoRemote, db : FirebaseFirestore, saveUserUC: SaveUserUC){

        viewModelScope.launch(Dispatchers.Main){

            val usnew = saveUserUC.saveUser(user, db)
            val usr = usnew.getOrNull()

            if(usr != null){
                _userRemote.value = usr
            }
            else{
                (UserDtoRemote(
                    "",
                    "Usuario no registrado",
                    ""))
            }
        }
    }
}