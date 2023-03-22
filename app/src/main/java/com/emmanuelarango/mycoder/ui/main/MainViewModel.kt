package com.emmanuelarango.mycoder.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){

    val isErrorValidation: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val resetError: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun Validations(name: String, email: String, password: String, repPassword: String) {

        if (name.isNullOrEmpty()){
            isErrorValidation.value = 1

        }else{
            resetError.value = 1
        }

        if (email.isNullOrEmpty()){
            isErrorValidation.value = 2

        }else{
            resetError.value = 2
        }

        if (password.isNullOrEmpty()){
            isErrorValidation.value = 3
        }else{
            resetError.value = 3
        }

        if (password != repPassword){
            isErrorValidation.value = 4
        }else{
            resetError.value = 4
        }

    }


}