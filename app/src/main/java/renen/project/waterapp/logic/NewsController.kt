package renen.project.waterapp.logic

import android.content.Context
import renen.project.database.logicentity.DayWithDrinks

object NewsController {

    val newsKeys = listOf<String>("news1", "news2","news3", "news4", "news5", "news6", "news7",
        "news8", "news9","news10", "news11", "news12", "news13", "news14", "news15", "news16",
        "news17", "news18", "news19", "news20", "news21")

    fun getType(list: List<DayWithDrinks>, context: Context): String {

        return readIni(context)
    }

    fun readIni(context: Context): String{
        val reader = LanguageIniFileReader(context)
        val data = reader.readNextLanguage()
        val text = data[newsKeys.random()]
        return text ?: "ERROR"
    }

    enum class NewsType {
        NEWS,
        USER_DRINKS_A_LOT_OF_COFFEE,
        USER_DRANK_COFFEE,
        USER_DRINKS_A_LOT_OF_TEA,
        USER_DRINKS_A_LITTLE_WATER,
        USER_DRINKS_A_WATER_3_DAY,
        USER_DRINKS_A_WATER_7_DAY,
        USER_DRINKS_A_WATER_10_DAY,
        USER_DRINKS_A_WATER_14_DAY,
        USER_DRINKS_A_WATER_21_DAY,
        USER_DRINKS_A_WATER_MORE_THAN_21_DAY

    }
}