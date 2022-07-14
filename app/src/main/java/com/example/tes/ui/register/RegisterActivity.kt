package com.example.tes.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crudsample.utils.extension.Event
import com.example.tes.databinding.ActivityRegisterBinding
import com.example.tes.ui.login.LoginActivity
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {

    private val viewModel : RegisterViewModel by viewModel()
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submit.setOnClickListener {
            addPost()
        }

    }
    private fun addPost(){
        val email = binding.email.text.toString().lowercase()
        val username = binding.username.text.toString().lowercase()
        val password = binding.password.text.toString().lowercase()



        viewModel.isNavigateTo.observe(this) { status ->
            if (status == true) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        viewModel.postUserClick(email, username, password)
        viewModel.snackBarText.observe(this) {
            showSnackBar(it)
        }


    }
    private fun showSnackBar(eventMessage: Event<Int>) {
        val message = eventMessage.getContentIfNotHandled() ?: return
        Snackbar.make(
            binding.constraint,
            getString(message),
            Snackbar.LENGTH_SHORT
        ).show()
    }
}