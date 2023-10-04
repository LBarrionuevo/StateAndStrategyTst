package com.testes.stateAndStrategy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.testes.stateAndStrategy.databinding.ActivityMain3Binding
import com.testes.stateAndStrategy.stateV2.ScreenStatesV2
import com.testes.stateAndStrategy.stateV2.ScreenStatesV2.*
import kotlin.random.Random

class MainActivity3 : AppCompatActivity() {

    //
    val binding by lazy{
        ActivityMain3Binding.inflate(layoutInflater)
    }

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initalState()
    }
    //
    private fun initalState() {
        handleState(
            StartTrip{
                if(Random.nextInt(0,5) <= 2){
                    goToStopTrip()
                }else{
                    goToInnerStrip()
                }
            }
        )
    }

    private fun goToInnerStrip() {
        handleState(
            InnerTrip{
                goToStopTrip()
            }
        )
    }

    private fun handleState(state: ScreenStatesV2){
        state.refreshScreen(binding = binding)
    }

//    private fun refreshScreen(label: String?, onClick: () -> Unit){
//        with(binding){
//            button.text = label.orEmpty()
//            button.setOnClickListener {
//                onClick.invoke()
//            }
//        }
//    }

    private fun goToStopTrip() {
        handleState(
            StopTrip {
                initalState()
            }
        )
    }
}