package com.android.stateexample

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.stateexample.ToasterState.Off
import com.android.stateexample.ToasterState.On

class Toaster(var context: Context) {
    var state: MutableLiveData<State> = MutableLiveData()
    var on = On(this)
    var off = Off(this)

    init {
        state.value = Off(this)
    }

    fun toastBread(cash:String) {
        state.value?.action(cash)
    }

}