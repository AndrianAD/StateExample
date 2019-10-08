package com.android.stateexample.states

import com.android.stateexample.State
import com.android.stateexample.WashMashine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WorkingState(var washMashine: WashMashine) : State {


    override fun init(cash:String) {
        CoroutineScope(Dispatchers.Default).launch {
            delay(cash.toLong()*1000)
            washMashine.state.postValue(washMashine.finishState)
        }
    }

    override fun action(cash:String) {
        washMashine.state.value = washMashine.waitingCashState
    }
}