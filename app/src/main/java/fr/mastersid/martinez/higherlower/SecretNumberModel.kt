package fr.mastersid.martinez.higherlower

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SecretNumberModel(state: SavedStateHandle, private val _max: Int, private val _turns: Int) : ViewModel() {
    private val _secretNumber = state.getLiveData(STATE_KEY_SECRET_NUMBER, NO_SECRET_NUMBER)
    val secretNumber: LiveData<Int> get() = _secretNumber

    private val _checkresult = state.getLiveData(STATE_KEY_RESULT, NO_GUESS)
    val checkresult: LiveData<CheckResult> get() = _checkresult

    private val _remainingTurns = state.getLiveData(STATE_KEY_REMAINING_TURNS, _turns)
    val remainingTurns: LiveData<Int> get() = _remainingTurns

    fun chooseSecretNumber(){
        _secretNumber.value = (0.._max).random()
    }

    fun check(number: Int){
        when{
            _secretNumber.value!! > number -> _checkresult.value = CheckResult.GREATER
            _secretNumber.value!! < number -> _checkresult.value = CheckResult.LOWER
            _secretNumber.value!! == number -> _checkresult.value = CheckResult.EQUAL
        }

        _remainingTurns.value= _remainingTurns.value?.minus(1)
    }

    fun resetTurns() {
        _remainingTurns.value=_turns
        _checkresult.value = CheckResult.NO_GUESS
    }

    enum class CheckResult{
        LOWER, GREATER, EQUAL, NO_GUESS
    }

    companion object {
        const val NO_SECRET_NUMBER = -1
        private const val STATE_KEY_SECRET_NUMBER="state_key_secret_number"

        val NO_GUESS = CheckResult.NO_GUESS
        private const val STATE_KEY_RESULT="state_key_result"

        private const val STATE_KEY_REMAINING_TURNS="state_key_remaining_turns"
    }
}