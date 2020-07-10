package renen.project.waterapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

import renen.project.waterapp.viewmodel.DrinkViewModel
import renen.project.waterapp.viewmodel.Language
import renen.project.waterapp.viewmodel.TranslationViewModel

class MainActivity : AppCompatActivity() {

    lateinit var drinkViewModel: DrinkViewModel
    lateinit var translationViewModel: TranslationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        drinkViewModel = ViewModelProvider(this).get(DrinkViewModel::class.java)
        translationViewModel = ViewModelProvider(this).get(TranslationViewModel::class.java)
        translationViewModel.postLanguage(Language.RUSSIAN, this)
        setContentView(R.layout.activity_main)
    }

   
}