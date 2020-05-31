package renen.project.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class News(
    @PrimaryKey val newsId: Int,
    @ColumnInfo(name = "newsTypeId") val newsTypeId: Int,
    @ColumnInfo(name = "text") val text: Long
)