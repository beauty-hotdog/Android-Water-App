package renen.project.database.repository

import androidx.lifecycle.LiveData
import renen.project.database.dao.DayDao
import renen.project.database.dao.DrinkTypeDao
import renen.project.database.entity.DrinkType
import renen.project.database.logicentity.DayWithDrinks

class DrinkTypeRepository (private val drinkTypeDao: DrinkTypeDao){
    val allDrinkTypes: LiveData<List<DrinkType>> = drinkTypeDao.getAllDrinkTypes()
}