package renen.project.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Day(
    @PrimaryKey val dayId: Int,
    @ColumnInfo(name = "training") val training: Boolean,
    @ColumnInfo(name = "timestamp") val timestamp: Long


)