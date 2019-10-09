package com.android.stateexample.adapter

import androidx.lifecycle.MutableLiveData
import com.android.stateexample.State
import com.android.stateexample.Toaster
import com.android.stateexample.WashMachine


open class WashMachineAdapter(var toaster: Toaster) : WashMachine() {

    override var state: MutableLiveData<State>
        get() = super.state
        set(value) {}

    init {
        state.value=toaster.state.value
    }

    override fun start(cash: String) {
        toaster.toastBread(cash)
    }
}
