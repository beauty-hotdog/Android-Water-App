package renen.project.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DrinkIntake(
    @PrimaryKey val drinkIntakeId: Int,
    @ColumnInfo(name = "volume") val volume: Int,
    @ColumnInfo(name = "timestamp") val timestamp: Long,
    @ColumnInfo(name = "drinkTypeID") val drinkTypeID: Int,
    @ColumnInfo(name = "dayID") val dayID: Int

)