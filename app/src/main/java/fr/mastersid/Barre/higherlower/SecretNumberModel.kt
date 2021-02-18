package fr.mastersid.Barre.higherlower

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 *Created by Bryan BARRE on 18/02/2021.
 */
class SecretNumberModel: ViewModel() {


    val  secretNumber = MutableLiveData(NO_SECRET_NUMBER)
    fun chooseSecretNumber(){
        secretNumber.value=(1..100).random()
    }
    enum class CheckResult {
        LOWER, GREATER, EQUAL,NO_GUESS
    }
    val checkResult = MutableLiveData(CheckResult.NO_GUESS)

    fun Check(number:Int){
        if (secretNumber.value == NO_SECRET_NUMBER){
            checkResult.value=CheckResult.NO_GUESS
        }
        else if (number<secretNumber.value.toString().toInt()){
            checkResult.value=CheckResult.GREATER
        }
        else if (number>secretNumber.value.toString().toInt()){
            checkResult.value=CheckResult.LOWER
        }
        else {
            checkResult.value = CheckResult.EQUAL
        }
    }

    companion  object {
        const  val  NO_SECRET_NUMBER = -1
    }
}