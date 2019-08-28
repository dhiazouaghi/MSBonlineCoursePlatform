package android.example.msbonlineregistrationplatform.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [StudentProfile::class], version = 1, exportSchema = false)
abstract class OnlineCourseDatabase : RoomDatabase() {


    abstract fun OnlineCourseDatabaseDao(): OnlineCourseDatabaseDao


    companion object {

        @Volatile
        private var INSTANCE: OnlineCourseDatabase? = null

        fun getInstance(context: Context): OnlineCourseDatabase {

            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        OnlineCourseDatabase::class.java,
                        "online_course_database"
                    ).allowMainThreadQueries()
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                // insert the data on the IO Thread
                                ioThread {
                                    getInstance(context).OnlineCourseDatabaseDao().insert(StudentProfile(1,"a","1"))
                                }
                            }
                        })
                        .fallbackToDestructiveMigration()
                        .build()

                }
                INSTANCE = instance
                return instance
            }


            }

        }
    }

