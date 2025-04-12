package com.example.lab2chatproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chatlib.ChatLibrary

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ChatLibrary.start(this) // Запуск чата из библиотеки
        finish() // Закрываем MainActivity, чтобы остался только чат
    }
}