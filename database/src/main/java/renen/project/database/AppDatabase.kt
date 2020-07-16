package renen.project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import renen.project.database.dao.DayDao
import renen.project.database.dao.DrinkTypeDao
import renen.project.database.entity.*

@Database(
    entities = [
        Day::class,
        DrinkIntake::class,
        DrinkType::class,
        News::class,
        NewsType::class
    ], version = 2, exportSchema = false
)
public abstract class AppDatabase : RoomDatabase() {
    abstract fun drinkDao(): DayDao
    abstract fun drinkTypeDao(): DrinkTypeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "word_database"
            )
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        GlobalScope.launch {
                            getDatabase(context).drinkTypeDao().insertDrinkType(drinkTypesList)
                        }
                    }
                })
                .build()
            INSTANCE = instance
            return instance

        }
    }
}