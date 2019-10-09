package com.android.stateexample.washMachineStates

import com.android.stateexample.State
import com.android.stateexample.WashMachine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class WorkingState(var washMachine: WashMachine) : State {

    override fun init(cash: String) {
        CoroutineScope(Dispatchers.Default).launch {
            delay(cash.toLong() * 1000)
            washMachine.state.postValue(washMachine.finishState)
        }
    }

    override fun action(cash: String) {
        washMachine.state.value = washMachine.waitingCashState
    }
}