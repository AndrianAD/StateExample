package com.android.stateexample.states

import com.android.stateexample.State
import com.android.stateexample.WashMashine

class ReadyState(var washMashine: WashMashine) : State {


    override fun init(cash:String) {

    }

    override fun action(cash:String) {
        washMashine.state.value = washMashine.workingState
        (washMashine.state.value as WorkingState).init(cash)

    }

}