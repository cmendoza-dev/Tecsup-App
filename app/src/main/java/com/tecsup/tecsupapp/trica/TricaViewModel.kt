package com.tecsup.tecsupapp.trica

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TricaViewModel : ViewModel(){

    fun sumNumbers(
        practicaTeo1: String,
        practicaTeo2: String,
        practicaLab1: String,
        practicaLab2: String,
        practicaLab3: String,
        practicaLab4: String
    ): Double {
        val pTeo1 = practicaTeo1.toIntOrNull() ?: 0
        val pTeo2 = practicaTeo2.toIntOrNull() ?: 0
        val pLab1 = practicaLab1.toIntOrNull() ?: 0
        val pLab2 = practicaLab2.toIntOrNull() ?: 0
        val pLab3 = practicaLab3.toIntOrNull() ?: 0
        val pLab4 = practicaLab4.toIntOrNull() ?: 0

        return (pTeo1 + pTeo2)*0.30 + (pLab1 + pLab2 + pLab3 + pLab4)*0.70
    }





}

