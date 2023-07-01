package com.tecsup.tecsupapp.trica

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TricaViewModel : ViewModel() {

    // MUtableLiveData
    val tricaStringError = MutableLiveData<String>()

    fun sumNumbers(
        practicaTeo1: String,
        practicaTeo2: String,
        practicaLab1: String,
        practicaLab2: String,
        practicaLab3: String,
        practicaLab4: String

    ): Double {

        if (practicaTeo1.isEmpty()) {
            tricaStringError.value = "Ingrese una nota válida"
        } else if (practicaTeo2.isEmpty()) {
            tricaStringError.value = "Ingrese la Práctica 1"
        } else if (practicaLab1.isEmpty()) {
            tricaStringError.value = "Ingrese la Práctica 1"
        } else if (practicaLab2.isEmpty()) {
            tricaStringError.value = "Ingrese la Práctica 2"
        } else if (practicaLab3.isEmpty()) {
            tricaStringError.value = "Ingrese la Práctica 3"
        } else if (practicaLab4.isEmpty()) {
            tricaStringError.value = "Ingrese la Práctica 4"
        }


        val pTeo1 = practicaTeo1.toDoubleOrNull() ?: 0.0
        val pTeo2 = practicaTeo2.toDoubleOrNull() ?: 0.0
        val pLab1 = practicaLab1.toDoubleOrNull() ?: 0.0
        val pLab2 = practicaLab2.toDoubleOrNull() ?: 0.0
        val pLab3 = practicaLab3.toDoubleOrNull() ?: 0.0
        val pLab4 = practicaLab4.toDoubleOrNull() ?: 0.0

        if (pTeo1 < 0 && pTeo1 > 20 || pTeo2 < 0 && pTeo2 > 20 || pLab1 < 0 && pLab1 > 20 || pLab2 < 0 && pLab2 > 20 || pLab3 < 0 && pLab3 > 20 || pLab4 < 0 && pLab4 > 20) {
            tricaStringError.value = "Ingrese una nota válida"
        }

        return (pTeo1 + pTeo2) / 2 * 0.40 + (pLab1 + pLab2 + pLab3 + pLab4) / 4 * 0.60

    }
}


