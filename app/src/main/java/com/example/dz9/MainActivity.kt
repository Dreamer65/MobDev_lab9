package com.example.dz9

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var emailText: EditText
    private lateinit var passwordText: EditText
    private lateinit var loginButton: Button
    private lateinit var forgotText: TextView

    var login: String = "dreamer"
    var password: String = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        emailText = findViewById(R.id.Edit_text_Email)
        passwordText = findViewById(R.id.Edit_text_password)
        loginButton = findViewById(R.id.Button_login)
        forgotText = findViewById(R.id.forgot_password)

        loginButton.setOnClickListener{
            if (emailText.text.toString() == login && passwordText.text.toString() == password)
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
        }


        forgotText.setOnClickListener {
            val intent = Intent(this@MainActivity, ForgotActivity::class.java)
            startActivityForResult(intent,100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == 100 && data != null){
            login = data.getStringExtra("mail") ?: login
            password = data.getStringExtra("password") ?: password
        }
    }
}