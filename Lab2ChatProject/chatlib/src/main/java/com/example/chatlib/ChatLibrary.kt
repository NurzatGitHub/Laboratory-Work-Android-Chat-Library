package com.example.chatlib

import android.content.Context
import android.content.Intent
import com.example.chatlib.chat.ChatActivity

object ChatLibrary {
    fun start(context: Context) {
        val intent = Intent(context, ChatActivity::class.java)
        context.startActivity(intent)
    }
}