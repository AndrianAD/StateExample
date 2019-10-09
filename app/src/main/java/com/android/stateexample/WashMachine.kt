package com.android.stateexample

import androidx.lifecycle.MutableLiveData
import com.android.stateexample.washMachineStates.FinishState
import com.android.stateexample.washMachineStates.ReadyState
import com.android.stateexample.washMachineStates.WaitingCashState
import com.android.stateexample.washMachineStates.WorkingState


open class WashMachine {
    open var state: MutableLiveData<State> = MutableLiveData()
    open var waitingCashState = WaitingCashState(this)
    open var readyState = ReadyState(this)
    open var workingState = WorkingState(this)
    open var finishState = FinishState(this)


    init {
        state.value = waitingCashState
    }

   open fun start(cash: String) {
        state.value?.action(cash)
    }

}

