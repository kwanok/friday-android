package com.example.friday.ui.chatrooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatRoomsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is chatRooms Fragment"
    }
    val text: LiveData<String> = _text
}