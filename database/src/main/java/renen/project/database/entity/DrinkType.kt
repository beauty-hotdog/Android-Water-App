package renen.project.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class DrinkType(
    @PrimaryKey val drinkTypeId: Int,
    @ColumnInfo(name = "waterPercentage") val waterPercentage: Int,
    @ColumnInfo(name = "influence") val influence: Boolean,
    @ColumnInfo(name = "text") val text: String
)
