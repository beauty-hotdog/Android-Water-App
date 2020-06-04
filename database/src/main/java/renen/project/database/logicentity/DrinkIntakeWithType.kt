package renen.project.database.logicentity

import androidx.room.Embedded
import androidx.room.PrimaryKey
import androidx.room.Relation
import renen.project.database.entity.DrinkIntake
import renen.project.database.entity.DrinkType

data class DrinkIntakeWithType (
    @Embedded val drinkIntake: DrinkIntake,
    @Relation(
        parentColumn = "drinkIntakeId",
        entityColumn = "drinkTypeId"
    )
    val drinkType: DrinkType
)

