package com.android.stateexample.states

import com.android.stateexample.State
import com.android.stateexample.WashMachine

class ReadyState(var washMachine: WashMachine) : State {


    override fun init(cash:String) {

    }

    override fun action(cash:String) {
        washMachine.state.value = washMachine.workingState
        (washMachine.state.value as WorkingState).init(cash)

    }

}