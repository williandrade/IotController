package williandrade.me.iotcontroller.dto

data class HomeCardDTO(
        val icon: Int,
        val name: String,
        val type: String,
        val on: Boolean = false
)