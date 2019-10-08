package com.android.stateexample

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.stateexample.states.FinishState
import com.android.stateexample.states.ReadyState
import com.android.stateexample.states.WaitingCashState
import com.android.stateexample.states.WorkingState

class WashMashine(var context: Context) {


    var state: MutableLiveData<State> = MutableLiveData()
    var waitingCashState = WaitingCashState(this)
    var readyState = ReadyState(this)
    var workingState = WorkingState(this)
    var finishState = FinishState(this)


    init {
        state.value = waitingCashState
    }

    //if state is...
    fun start(cash:String) {
        state.value?.action(cash)
    }

}

