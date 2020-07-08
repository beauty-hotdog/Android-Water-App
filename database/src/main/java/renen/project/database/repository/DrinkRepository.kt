package renen.project.database.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import renen.project.database.dao.DayDao
import renen.project.database.logicentity.DayWithDrinks

class DrinkRepository (private val dayDao: DayDao){
    val allDays: LiveData<List<DayWithDrinks>> = dayDao.getAllDays()
}