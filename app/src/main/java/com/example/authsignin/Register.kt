package com.example.authsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.authsignin.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            if (binding.etEmail.text.toString().isEmpty()) {
                binding.etEmail.error = "Enter your email"
            } else if (binding.etPassword.text.toString().isEmpty()) {
                binding.etPassword.error = "Enter your email"
            } else {
                System.out.println("Register")
                auth.createUserWithEmailAndPassword(
                    binding.etEmail.text.toString(), binding.etPassword.text.toString()
                ).addOnSuccessListener {
                    Toast.makeText(applicationContext, "Successfully Register", Toast.LENGTH_SHORT)
                        .show()
                   // startActivity(Intent(this, FirebaseAuthException::class.java))
                    //finish()
                }
                    .addOnFailureListener {
                        System.out.println("error $it")
                        Toast.makeText(applicationContext, "Error${it.toString()}", Toast.LENGTH_SHORT).show()
                    }
            }
            binding.alreadyRegister.setOnClickListener {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}