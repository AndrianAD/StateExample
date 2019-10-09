package com.android.stateexample.ToasterState

import com.android.stateexample.State
import com.android.stateexample.Toaster

class Off(var toaster: Toaster) :
    State {

    override fun init(cash: String) {

    }

    override fun action(cash: String) {
        toaster.state.value = toaster.on
        (toaster.state.value as On).init(cash)
    }

}