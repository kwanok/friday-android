package com.example.friday.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.friday.FridayApplication
import com.example.friday.R
import com.example.friday.RetrofitService
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginBtn: Button = findViewById(R.id.loginButton)
        loginBtn.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            login(email, password)
        }
    }

    private fun login(email: String, password: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val server: RetrofitService = retrofit.create(RetrofitService::class.java)

        val loginRequest = LoginRequest(
            email=email,
            password=password,
        )

        server.postRequest(loginRequest).enqueue(object : Callback<ResponseDTO> {
            override fun onFailure(call: Call<ResponseDTO>?, t: Throwable?) {
                Log.e("retrofit", t.toString())
            }

            override fun onResponse(
                call: Call<ResponseDTO>?,
                response: Response<ResponseDTO>?
            ) {
                if (response?.body()?.accessToken != null ) {

                    FridayApplication.prefs.setString("accessToken",
                        response.body()!!.accessToken
                    )

                    FridayApplication.prefs.setString("refreshToken",
                        response.body()!!.refreshToken
                    )
                }
            }
        })
    }
}