package com.testes.stateAndStrategy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.testes.stateAndStrategy.databinding.ActivityMainBinding
import com.testes.stateAndStrategy.states.InterTrip
import com.testes.stateAndStrategy.states.LayoutState
import com.testes.stateAndStrategy.states.StartTrip
import com.testes.stateAndStrategy.states.StopTrip

class MainActivity : AppCompatActivity() {

    //
    val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    val state by lazy{
        StrategyExample(
            binding
        )
    }
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initalState()
    }
    //
    private fun initalState() {
        //
        state.refreshScreen(
            StartTrip(
            "Comece",
            onClick = {
                reloadButton(InterTrip("Encerrar", onClick = { initalState() }))
            }
        ))
    }
    //
    private fun reloadButton(layoutState: LayoutState) {
        state.refreshScreen(layoutState)
    }
}