package com.example.friday.ui.chatrooms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.friday.R

class ChatRoomsFragment : Fragment() {
    private lateinit var chatRoomsViewModel: ChatRoomsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        chatRoomsViewModel =
            ViewModelProviders.of(this).get(ChatRoomsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_chat_rooms, container, false)
        val textView: TextView = root.findViewById(R.id.text_chat_rooms)
        chatRoomsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}