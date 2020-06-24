package renen.project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import renen.project.database.dao.DayDao
import renen.project.database.entity.*

@Database(
    entities = [
        Day::class,
        DrinkIntake::class,
        DrinkType::class,
        News::class,
        NewsType::class
    ], version = 1, exportSchema = false
)
public abstract class AppDatabase : RoomDatabase() {
    abstract fun drinkDao(): DayDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}