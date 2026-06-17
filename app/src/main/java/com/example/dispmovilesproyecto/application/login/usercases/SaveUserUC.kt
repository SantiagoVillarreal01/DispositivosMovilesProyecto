package com.example.dispmovilesproyecto.application.login.usercases

import com.example.dispmovilesproyecto.data.remote.dto.UserDtoRemote
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class SaveUserUC {

    suspend fun saveUser(user: UserDtoRemote, db : FirebaseFirestore): Result<UserDtoRemote>{
        var resp = db.collection("users")
            .add(user)
            .await().runCatching{
                user
            }

        return resp;
    }
}