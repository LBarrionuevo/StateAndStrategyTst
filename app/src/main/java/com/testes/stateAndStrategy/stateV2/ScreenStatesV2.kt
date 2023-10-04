package com.testes.stateAndStrategy.stateV2

import com.testes.stateAndStrategy.databinding.ActivityMain3Binding

sealed class ScreenStatesV2 {

    abstract fun refreshScreen(binding: ActivityMain3Binding)

    data class StartTrip(val label: String? = "Começo", val onClick: () -> Unit = {}) :
        ScreenStatesV2() {
        override fun refreshScreen(binding: ActivityMain3Binding) {
            with(binding.button) {
                text = label
                setOnClickListener {
                    onClick.invoke()
                }
            }
        }
    }

    data class InnerTrip(val label: String? = "Quase lá", val onClick: () -> Unit = {}) :
        ScreenStatesV2() {
        override fun refreshScreen(binding: ActivityMain3Binding) {
            with(binding.button) {
                text = label
                setOnClickListener {
                    onClick.invoke()
                }
            }
        }
    }

    data class StopTrip(val label: String? = "Encerrar", val onClick: () -> Unit = {}) :
        ScreenStatesV2() {
        override fun refreshScreen(binding: ActivityMain3Binding) {
            with(binding.button) {
                text = label
                setOnClickListener {
                    onClick.invoke()
                }
            }
        }
    }

}
