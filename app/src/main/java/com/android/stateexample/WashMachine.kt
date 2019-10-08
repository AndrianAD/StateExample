package com.android.stateexample

import androidx.lifecycle.MutableLiveData
import com.android.stateexample.states.FinishState
import com.android.stateexample.states.ReadyState
import com.android.stateexample.states.WaitingCashState
import com.android.stateexample.states.WorkingState



                    class WashMachine {
                        var state: MutableLiveData<State> = MutableLiveData()
                        var waitingCashState = WaitingCashState(this)
                        var readyState = ReadyState(this)
                        var workingState = WorkingState(this)
                        var finishState = FinishState(this)


                        init {
                            state.value = waitingCashState
                        }

                        fun start(cash:String) {
                            state.value?.action(cash)
                        }

                    }

