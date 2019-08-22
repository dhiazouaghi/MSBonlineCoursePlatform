package android.example.msbonlineregistrationplatform


import android.example.msbonlineregistrationplatform.database.OnlineCourseDatabase
import android.example.msbonlineregistrationplatform.database.OnlineCourseDatabaseDao
import android.example.msbonlineregistrationplatform.database.StudentProfile

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry


import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException




@RunWith(AndroidJUnit4::class)
class SleepDatabaseTest {

    private lateinit var ocDao: OnlineCourseDatabaseDao
    private lateinit var db: OnlineCourseDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, OnlineCourseDatabase::class.java)

            .allowMainThreadQueries()
            .build()
        ocDao= db.OnlineCourseDatabaseDao

    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test

    @Throws(Exception::class)
    fun insertAndGetStudent() {
        val student = StudentProfile()
        ocDao.insert(student)
        val one = ocDao.gettheStudent()
        assertEquals(one?.department, -1)
    }
}