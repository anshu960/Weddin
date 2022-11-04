package com.example.weddin.Model

import java.io.Serializable

data class User (
    val id: Int,
    val title: String,
    val image: String,
    val description: String,
    val date: String,
    val location: String,
    val latitude: Double,
    val longitude: Double
        ) : Serializable