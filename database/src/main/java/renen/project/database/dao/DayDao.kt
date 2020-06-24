package renen.project.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import renen.project.database.logicentity.DayWithDrinks

@Dao
interface DayDao {
    @Query("SELECT * from day")
    fun getAllDays(): LiveData<List<DayWithDrinks>>
}