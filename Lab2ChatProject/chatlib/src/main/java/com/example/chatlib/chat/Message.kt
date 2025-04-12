package com.example.chatlib.chat

data class Message(
    val text: String,
    val isSent: Boolean // true — user, false — server
)