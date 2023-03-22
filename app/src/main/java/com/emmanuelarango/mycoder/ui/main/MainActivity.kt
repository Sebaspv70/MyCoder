package com.emmanuelarango.mycoder.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.emmanuelarango.mycoder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var MainBinding: ActivityMainBinding
    private lateinit var mainViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = MainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]


        val isErrorValidationObserver = Observer<Int>{validation ->

            if (validation == 1) {
                Toast.makeText(
                    applicationContext,
                    "Nombre de usuario Vacio",
                    Toast.LENGTH_LONG
                ).show()
                MainBinding.nameTextInputLayout.error = "Nombre de usuario Vacio"
                MainBinding.nameEditText.setText("")

            }else if(validation == 2){
                Toast.makeText(
                    applicationContext,
                    "Correo de usuario Vacio",
                    Toast.LENGTH_LONG
                ).show()

                MainBinding.emailTextInputLayout.error = "Correo de usuario Vacio"
                MainBinding.emailEditText.setText("")

            }else if(validation == 3){
                Toast.makeText(
                    applicationContext,
                    "Contraseña de usuario Vacio",
                    Toast.LENGTH_LONG
                ).show()

                MainBinding.passwordInputTextLayout.error = "Contraseña de usuario Vacio"
                MainBinding.passwordTextInput.setText("")

            }else if(validation == 4){
                Toast.makeText(
                    applicationContext,
                    "Las contraseñas no son iguales",
                    Toast.LENGTH_LONG
                ).show()

                MainBinding.repPasswordTextInputLayout.error = "Las contraseñas no son iguales"
                MainBinding.repPasswordTextInput.setText("")
            }
        }

        val resetErrorObserver = Observer<Int>{reset ->

            if (reset == 1) {
                MainBinding.nameTextInputLayout.isErrorEnabled = false
            }else if(reset == 2){
                MainBinding.emailTextInputLayout.isErrorEnabled = false
            }else if(reset == 3){
                MainBinding.passwordInputTextLayout.isErrorEnabled = false
            }else if(reset == 4){
                MainBinding.repPasswordTextInputLayout.isErrorEnabled = false
            }
        }


        mainViewModel.isErrorValidation.observe(this, isErrorValidationObserver)
        mainViewModel.resetError.observe(this, resetErrorObserver)



        MainBinding.registerButton.setOnClickListener {

            val name = MainBinding.nameEditText.text.toString()
            val email = MainBinding.emailEditText.text.toString()
            val password = MainBinding.passwordTextInput.text.toString()
            val repPassword = MainBinding.repPasswordTextInput.text.toString()


            mainViewModel.Validations(name,email,password,repPassword)

        }



    }
}