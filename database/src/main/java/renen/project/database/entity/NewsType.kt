package renen.project.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsType(
    @PrimaryKey val newsTypeId: Int,
    @ColumnInfo(name = "text") val text: String

)