package renen.project.waterapp.ui.home

import renen.project.waterapp.R

class DrinkBottomEntity(
    private val resId: Int, val waterPercentage: Int, val influence: Boolean,
    val text: String
) {
    val resource: Int

    init {
        when (resId) {
            0 -> {
                resource = R.drawable.ic_cup_water
            }
            1 -> {
                resource = R.drawable.ic_cup_coffee
            }
            2 -> {
                resource = R.drawable.ic_cup_water
            }
            3 -> {
                resource = R.drawable.ic_cup_coffee
            }
            else -> {
                resource = R.drawable.ic_cup_water
            }
        }
    }
}
