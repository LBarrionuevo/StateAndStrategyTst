package com.testes.stateAndStrategy.states

import android.view.View.OnClickListener
import com.testes.stateAndStrategy.databinding.ActivityMainBinding

sealed class LayoutState(
    private val label: String?,
    private val onClick: OnClickListener?
) {
    fun setLabelsAndAction(binding: ActivityMainBinding){
        binding.button.text = label
        binding.button.setOnClickListener(onClick)
    }
}






