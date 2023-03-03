package com.example.imdbsandbox.database.moviedatabase

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.imdbsandbox.network.models.Movie

@Database(entities = [Movie::class], version = 1)
@TypeConverters(MyDataClassTypeConverter::class,
    MyDataClass2TypeConverter::class,
    MyDataClass3TypeConverter::class,
    MyDataClass4TypeConverter::class,
    MyDataClass6TypeConverter::class,
    MyDataClass5TypeConverter::class,
    MyDataClass7TypeConverter::class)
abstract class MovieDatabase: RoomDatabase(){

    abstract fun movieDao(): MovieDao

    companion object{
        private const val DB_NAME = "movie_database"

        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Movie)

    @Update
    suspend fun update(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)
    //WHERE isFavorite = 1 ORDER BY name
    @Query("SELECT * FROM movie")
    suspend fun getFavoriteMovies(): List<Movie>
}