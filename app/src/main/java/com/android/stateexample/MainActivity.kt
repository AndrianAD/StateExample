package com.android.stateexample

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.android.stateexample.states.FinishState
import com.android.stateexample.states.ReadyState
import com.android.stateexample.states.WaitingCashState
import com.android.stateexample.states.WorkingState
import kotlinx.android.synthetic.main.activity_main.*


fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var washMachine = WashMachine()
        washMachine.state.observe(this, Observer {
            when (it) {
                is WaitingCashState -> {
                    next.text = "Next"
                    editText.apply {
                        visibility=View.VISIBLE
                        text.clear()
                    }
                    state.text = "WaitingCashState"
                    lottiAnimation.apply {
                        setAnimation("spend.json")
                        playAnimation()
                        loop(true)
                    }

                }
                is ReadyState -> {
                    editText.visibility = View.GONE
                    state.text = "ReadyState"
                    info.text= "You have paid for ${editText.text} minutes"
                    lottiAnimation.setAnimation("washing.json")
                }
                is WorkingState -> {
                    info.text="Waiting please..."
                    next.text = "Stop"
                    state.text = "WorkingState"
                    lottiAnimation.apply {
                        playAnimation()
                        loop(true)
                    }
                }
                is FinishState -> {
                    state.text = "FinishState"
                    lottiAnimation.cancelAnimation()

                    val alertView = layoutInflater.inflate(
                            (R.layout.dialog_upload_succes),
                            null)
                    val alertDialog = AlertDialog.Builder(this@MainActivity)
                            .setView(alertView)
                            .show()
                    alertView.setOnClickListener { alertDialog.dismiss() }
                    alertDialog.setOnDismissListener {
                        washMachine.state.value=washMachine.waitingCashState
                    }

                }
            }
        })


        next.setOnClickListener {
            if (editText.text.isNullOrEmpty().not())
                washMachine.start(editText.text.toString())
        }

    }


}






