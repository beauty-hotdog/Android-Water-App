package renen.project.waterapp.logic

import android.content.Context
import renen.project.waterapp.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.*
import kotlin.collections.HashMap

class LanguageIniFileReader(private val context: Context) {

    fun readIniFile(resource: Int): HashMap<String, String> {
        val properties = Properties()
            .apply {
                load(
                    BufferedReader(
                        InputStreamReader(
                            context.resources.openRawResource(resource),
                            StandardCharsets.UTF_8
                        )
                    )
                )
            }
        return readTranslationsFromProperties(properties)
    }

    /**
     * Properties have specific structure, so we're reading them like this
     */
    private fun readTranslationsFromProperties(properties: Properties): HashMap<String, String> {
        val translations = HashMap<String, String>()
        val props = properties
        for (key in props.stringPropertyNames()) {
            translations[key] = props.getProperty(key, "ERROR")
        }
        return translations
    }
}