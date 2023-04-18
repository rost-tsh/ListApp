package com.example.listapp

import java.io.Serializable

//класс для хранения данных 1 эллемента
data class Plant(val imageId: Int, val title: String, val desc: String): Serializable
