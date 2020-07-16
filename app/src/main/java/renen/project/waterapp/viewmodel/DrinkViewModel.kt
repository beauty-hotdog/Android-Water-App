package renen.project.waterapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import renen.project.database.AppDatabase
import renen.project.database.entity.DrinkType
import renen.project.database.logicentity.DayWithDrinks
import renen.project.database.repository.DrinkRepository
import renen.project.database.repository.DrinkTypeRepository

public class DrinkViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: DrinkRepository
    private val drinkTypeRepository: DrinkTypeRepository

    val allDays: LiveData<List<DayWithDrinks>>
    val allDrinkTypes: LiveData<List<DrinkType>>

    init {
        val db = AppDatabase.getDatabase(application)
        val drinkDao = db.drinkDao()
        repository = DrinkRepository(drinkDao)
        allDays = repository.allDays

        val drinkTypeDao = db.drinkTypeDao()
        drinkTypeRepository = DrinkTypeRepository(drinkTypeDao)
        allDrinkTypes = drinkTypeRepository.allDrinkTypes
    }
}