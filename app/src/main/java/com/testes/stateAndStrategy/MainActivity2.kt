package com.testes.stateAndStrategy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.testes.stateAndStrategy.databinding.ActivityMain2Binding
import com.testes.stateAndStrategy.stateV2.ScreenStates
import com.testes.stateAndStrategy.stateV2.ScreenStates.*
import com.testes.stateAndStrategy.states.LayoutState
import com.testes.stateAndStrategy.states.StopTrip
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {

    //
    val binding by lazy{
        ActivityMain2Binding.inflate(layoutInflater)
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

    private fun handleState(state: ScreenStates){
        when(state){
            is InnerTrip -> refreshScreen(state.label,state.onClick)
            is StartTrip -> refreshScreen(state.label,state.onClick)
            is ScreenStates.StopTrip -> refreshScreen(state.label,state.onClick)
        }
    }

    private fun refreshScreen(label: String?, onClick: () -> Unit){
        with(binding){
            button.text = label.orEmpty()
            button.setOnClickListener {
                onClick.invoke()
            }
        }
    }

    private fun goToStopTrip() {
        handleState(
            StopTrip {
                initalState()
            }
        )
    }
}