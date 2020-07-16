package renen.project.database

import renen.project.database.entity.DrinkType

val drinkTypesList = listOf<DrinkType>(
    DrinkType(0, 0,100, false, "Вода"),
    DrinkType(1, 1,20, false, "Кофе"),
    DrinkType(2, 2,30, false, "Чай"),
    DrinkType(3, 3,-20, true, "Кофе")

)