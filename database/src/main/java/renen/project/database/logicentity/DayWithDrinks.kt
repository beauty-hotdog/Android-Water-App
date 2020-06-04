package renen.project.database.logicentity

import androidx.room.Embedded
import androidx.room.Relation
import renen.project.database.entity.Day
import renen.project.database.entity.DrinkIntake


data class DayWithDrinks(
    @Embedded val day: Day,
    @Relation(
        entity = DrinkIntake::class,
        parentColumn = "dayId",
        entityColumn = "dayId"
    )
    val drinkIntakeWithType: DrinkIntakeWithType
)