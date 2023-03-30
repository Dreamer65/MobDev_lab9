package com.example.dz9

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ForgotActivity : Activity() {
    private lateinit var emailText: EditText
    private lateinit var passwordText: EditText
    private lateinit var passRepeatText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        passwordText = findViewById(R.id.restore_text)
        emailText = findViewById(R.id.restore_email_text)
        passRepeatText = findViewById(R.id.repeat_text)
        button = findViewById(R.id.restore_button)

        button.setOnClickListener {

            if (passwordText.text.toString() != passRepeatText.text.toString())
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show()
            else {
                intent.putExtra("mail", emailText.text.toString())
                intent.putExtra("password", passwordText.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}