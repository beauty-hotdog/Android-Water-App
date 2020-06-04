package renen.project.database.logicentity

import androidx.room.Embedded
import androidx.room.Relation
import renen.project.database.entity.News
import renen.project.database.entity.NewsType

data class NewsWithType (
    @Embedded val news: News,
    @Relation(
        parentColumn = "newsId",
        entityColumn = "newsTypeId"
    )
    val newsType: NewsType
)

