package renen.project.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DrinkIntake(
    @PrimaryKey val drinkIntakeId: Int,
    @ColumnInfo(name = "volume") val volume: Int,
    @ColumnInfo(name = "timestamp") val timestamp: Long,
    @ColumnInfo(name = "drinkTypeId") val drinkTypeId: Int,
    @ColumnInfo(name = "dayId") val dayId: Int

)