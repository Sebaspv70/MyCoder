package com.emmanuelarango.mycoder.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.emmanuelarango.mycoder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var MainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = MainBinding.root
        setContentView(view)

        MainBinding.registerButton.setOnClickListener {

            var password = ""

            if (MainBinding.nameEditText.text.isNullOrEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Nombre de usuario Vacio",
                    Toast.LENGTH_LONG
                ).show()

                MainBinding.nameTextInputLayout.error = "Nombre de usuario Vacio"

            }else{
                val name = MainBinding.nameEditText.text.toString()
                MainBinding.nameTextInputLayout.isErrorEnabled = false
            }




            if (MainBinding.emailEditText.text.isNullOrEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Correo de usuario Vacio",
                    Toast.LENGTH_LONG
                ).show()

                MainBinding.emailTextInputLayout.error = "Correo de usuario Vacio"
            }else{
                val email = MainBinding.emailEditText.text.toString()
                MainBinding.emailTextInputLayout.isErrorEnabled = false
            }

            if (MainBinding.emailEditText.text.isNullOrEmpty()){
                Toast.makeText(
                    applicationContext,
                    "Correo de usuario Vacio",
                    Toast.LENGTH_LONG
                ).show()

                MainBinding.passwordInputTextLayout.error = "Correo de usuario Vacio"
            }else{
                password = MainBinding.passwordTextInput.text.toString()
                MainBinding.passwordInputTextLayout.isErrorEnabled = false
            }

            val repPassword = MainBinding.repPasswordTextInput.text.toString()

            if (password != repPassword){
                Toast.makeText(
                    applicationContext,
                    "Las contraseñas no son iguales",
                    Toast.LENGTH_LONG
                ).show()

                MainBinding.repPasswordTextInputLayout.error = "Las contraseñas no son iguales"
                MainBinding.repPasswordTextInput.setText("")
            }

        }



    }
}