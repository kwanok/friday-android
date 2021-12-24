package com.example.friday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn: Button = findViewById(R.id.loginButton)
        loginBtn.setOnClickListener {
            val email: EditText = findViewById(R.id.email)
            val password: EditText = findViewById(R.id.password)


            val queue = Volley.newRequestQueue(this)
            val url = "http://10.0.2.2:8080/"

            val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response ->
                    // Display the first 500 characters of the response string.
                    Log.d("res", response)
                },
                { err ->
                    Log.d("err", err.toString())
                }
            )

            queue.add(stringRequest)
        }
    }
}