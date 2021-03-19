package fr.mastersid.Barre.higherlower

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlin.math.absoluteValue

/**
 *Created by Bryan BARRE on 18/02/2021.
 */
class SecretNumberModel(state : SavedStateHandle, private val turn:Int,private val max:Int):ViewModel () {

    val secretNumber = MutableLiveData(NO_SECRET_NUMBER)
    val nbTurn=MutableLiveData(NO_TURN)
    val retryState = MutableLiveData(RETRY_TIME)

    val checkResult = MutableLiveData(CheckResult.NO_GUESS)


    enum class CheckResult {
        LOWER, GREATER, EQUAL,NO_GUESS
    }
    enum class CheckTurn{
        NO_TURN_AVAILABLE,TURN_AVAILABLE
    }

    enum class State{
        ON,OFF
    }

    fun chooseSecretNumber() {
        secretNumber.value=(1..max).random()
        setTurn()

    }

    fun retry(){
        retryState.value=1
        secretNumber.value= NO_SECRET_NUMBER
    }

    fun setTurn(){
        nbTurn.value=turn
    }

    fun check(number:Int) {
        when {
            secretNumber.value == NO_SECRET_NUMBER -> {
                checkResult.value = CheckResult.NO_GUESS
            }
            number < secretNumber.value.toString().toInt() -> {
                checkResult.value = CheckResult.GREATER
            }
            number > secretNumber.value.toString().toInt() -> {
                checkResult.value = CheckResult.LOWER
            }
            else -> {
                checkResult.value = CheckResult.EQUAL
            }
        }

        when {
            nbTurn.value!! > 0 -> {
                nbTurn.value = nbTurn.value?.minus(1)
            }
            nbTurn.value == 0 -> {
                nbTurn.value = 0

            }
        }
    }



    companion  object {
        const  val  NO_SECRET_NUMBER = -1
        const  val  NO_TURN = -1
        const val RETRY_TIME=-1
    }
}