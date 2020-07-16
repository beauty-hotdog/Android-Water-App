package renen.project.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import renen.project.database.entity.DrinkType
import renen.project.database.logicentity.DayWithDrinks

@Dao
interface DrinkTypeDao {
    @Query("SELECT * from drinktype")
    fun getAllDrinkTypes(): LiveData<List<DrinkType>>

    @Insert
    fun insertDrinkType(drinkType: DrinkType)

    @Insert
    fun insertDrinkType(drinkType: List<DrinkType>)
}