package com.example.materialloginform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class ResetPassword : AppCompatActivity() {

    private lateinit var etpassword:EditText
    private lateinit var btnresetpassword:Button

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        etpassword=findViewById(R.id.et_reset_email)
        btnresetpassword=findViewById(R.id.btn_reset)

        auth=FirebaseAuth.getInstance()
        btnresetpassword.setOnClickListener {
         val sPassword=  etpassword.text.toString()
            auth.sendPasswordResetEmail(sPassword)
                .addOnSuccessListener {
                    Toast.makeText(this,"please check your Email",Toast.LENGTH_SHORT).show()

                }
                .addOnFailureListener {
                    Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
                }
        }

    }
}