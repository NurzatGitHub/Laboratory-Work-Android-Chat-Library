package com.example.chatlib.chat

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatlib.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity(), ChatWebSocketClient.ChatListener {
    private lateinit var binding: ActivityChatBinding
    private lateinit var adapter: MessageAdapter
    private lateinit var webSocketClient: ChatWebSocketClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MessageAdapter(mutableListOf())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        webSocketClient = ChatWebSocketClient("wss://echo.websocket.org/", this)
        webSocketClient.connect()

        binding.sendButton.setOnClickListener {
            val message = binding.inputMessage.text.toString()
            if (message.isNotEmpty()) {
                adapter.addMessage(Message(message, true))
                webSocketClient.sendMessage(message)
                binding.inputMessage.text.clear()
                Log.d("Chat", "Message sent: $message")
            }
        }
    }

    override fun onMessageReceived(message: String) {
        runOnUiThread {
            val displayMessage = if (message == "203 = 0xcb") "Предопределённое сообщение" else message
            adapter.addMessage(Message(displayMessage, false))
            binding.recyclerView.smoothScrollToPosition(adapter.itemCount - 1)
            Log.d("Chat", "Message received: $displayMessage")
        }
    }

    override fun onConnected() {
        Log.d("Chat", "WebSocket connected")
    }

    override fun onDisconnected() {
        Log.d("Chat", "WebSocket disconnected")
    }

    override fun onError(t: Throwable) {
        Log.e("Chat", "WebSocket error", t)
        runOnUiThread {
            Toast.makeText(this, "Connection error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        if (::webSocketClient.isInitialized) {
            webSocketClient.disconnect()
        }
        super.onDestroy()
    }
}