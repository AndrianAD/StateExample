package com.android.stateexample.ToasterState

import com.android.stateexample.State
import com.android.stateexample.Toaster
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class On(var toaster: Toaster) :
    State {

    override fun init(cash: String) {
        CoroutineScope(Dispatchers.Default).launch {
            delay(cash.toLong() * 1000)
            toaster.state.postValue(toaster.off)
        }
    }

    override fun action(cash: String) {
        toaster.state.postValue(toaster.off)
    }

}