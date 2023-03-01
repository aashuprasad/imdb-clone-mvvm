package com.example.imdbsandbox.database.register

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.imdbsandbox.network.models.Movie

@Entity(tableName = "Register_users_table")
data class RegisterEntity (
    @PrimaryKey(autoGenerate = true)
    var userId : Int = 0,

    @ColumnInfo(name = "first_name")
    var firstName: String,

    @ColumnInfo(name = "last_name")
    var lastName: String,

    @ColumnInfo(name = "user_name")
    var userName: String,

    @ColumnInfo(name = "password_text")
    var password: String,



)

