package com.testes.stateAndStrategy

import com.testes.stateAndStrategy.databinding.ActivityMainBinding
import com.testes.stateAndStrategy.states.LayoutState

class StrategyExample(
    val binding: ActivityMainBinding,
) {

    fun refreshScreen(stateStrategy: LayoutState){
        stateStrategy.setLabelsAndAction(binding)
    }
}