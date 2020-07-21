package renen.project.waterapp

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
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
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.setBackgroundDrawable(ColorDrawable(Color.WHITE));
        setContentView(R.layout.activity_main)
    }

   
}