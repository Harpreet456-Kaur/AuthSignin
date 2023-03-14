package com.example.authsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.authsignin.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            if (binding.etEmail.text.toString().isEmpty()){
                binding.etEmail.error="Enter your email"
            }
            else if (binding.etPass.text.toString().isEmpty()) {
                binding.etPass.error = "Enter your email"
            }
            else{
                auth.signInWithEmailAndPassword(
                    binding.etEmail.text.toString(), binding.etPass.text.toString()).addOnSuccessListener {
                    Toast.makeText(applicationContext, "Successfully Login", Toast.LENGTH_SHORT).show()
                }
                    .addOnFailureListener {
                        Toast.makeText(applicationContext, "Error${it.toString()}", Toast.LENGTH_SHORT).show()
                    }
            }
        }
        binding.noAccount.setOnClickListener {
                var intent=Intent(this,Register::class.java)
                startActivity(intent)
            }
        }
    }