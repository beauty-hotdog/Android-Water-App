package renen.project.waterapp.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import renen.project.database.AppDatabase
import renen.project.database.logicentity.DayWithDrinks
import renen.project.database.repository.DrinkRepository
import renen.project.waterapp.R
import renen.project.waterapp.logic.LanguageIniFileReader
import renen.project.waterapp.logic.NewsController
import su.leff.translator.Translator

public class TranslationViewModel(application: Application) : AndroidViewModel(application) {

    val translations = MutableLiveData<HashMap<String, String>>()
    val language = MutableLiveData<Language>()

    init {
    }

    fun postLanguage(newLanguage: Language, context: Context) {
        language.value = newLanguage
        when (newLanguage) {
            Language.ENGLISH -> {
                val data = readIni(context = context, resource = R.raw.translation_english)
                translations.value = data
                Translator.loadMap(data, context)
            }
            Language.RUSSIAN -> {
                val data = readIni(context = context, resource = R.raw.translation_russian)
                translations.value = data
                Translator.loadMap(data, context)
            }
        }
    }

    fun readIni(context: Context, resource: Int): HashMap<String, String> {
        val reader = LanguageIniFileReader(context)
        val data = reader.readIniFile(resource)
        return data
    }
}

enum class Language {
    ENGLISH,
    RUSSIAN

}