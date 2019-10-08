package com.android.stateexample.states

import com.android.stateexample.State
import com.android.stateexample.WashMachine




                    class WaitingCashState(var washMachine: WashMachine) : State {

                        override fun init(cash:String) {

                        }

                        override fun action(cash:String) {
                            washMachine.state.value = washMachine.readyState
                        }

                    }




