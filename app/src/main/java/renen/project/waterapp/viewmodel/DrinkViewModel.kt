package renen.project.waterapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import renen.project.database.AppDatabase
import renen.project.database.logicentity.DayWithDrinks
import renen.project.database.repository.DrinkRepository

public class DrinkViewModel (application: Application): AndroidViewModel(application){
    private val repository: DrinkRepository

    val allDays: LiveData<List<DayWithDrinks>>

    init {
        val drinkDao = AppDatabase.getDatabase(application).drinkDao()
        repository = DrinkRepository(drinkDao)
        allDays = repository.allDays
    }
}