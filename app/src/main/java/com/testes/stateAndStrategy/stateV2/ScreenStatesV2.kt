package com.testes.stateAndStrategy.stateV2

import com.testes.stateAndStrategy.databinding.ActivityMain3Binding

sealed class ScreenStatesV2(
    label: String?,
    onClick: () -> Unit
) {
    //Não recomendo
    fun refreshScreen(binding: ActivityMain3Binding) {
        with(binding.button) {
            text = _label
            setOnClickListener {
                _onClick.invoke()
            }
        }
    }

    private val _label = label
    private val _onClick = onClick

    data class StartTrip(val label: String? = "Começo", val onClick: () -> Unit = {}) :
        ScreenStatesV2(label, onClick = onClick)

    data class InnerTrip(val label: String? = "Quase lá", val onClick: () -> Unit = {}) :
        ScreenStatesV2(label, onClick = onClick)

    data class StopTrip(val label: String? = "Encerrar", val onClick: () -> Unit = {}) :
        ScreenStatesV2(label, onClick = onClick)

}
