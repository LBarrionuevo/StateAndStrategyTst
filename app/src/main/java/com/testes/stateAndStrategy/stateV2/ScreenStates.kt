package com.testes.stateAndStrategy.stateV2

sealed class ScreenStates{
    data class StartTrip(val label: String? = "Começo", val onClick: () -> Unit = {}) : ScreenStates()
    data class InnerTrip(val label: String? = "Quase lá", val onClick: () -> Unit= {}) : ScreenStates()
    data class StopTrip(val label: String? = "Encerrar", val onClick: () -> Unit= {}) : ScreenStates()
}
