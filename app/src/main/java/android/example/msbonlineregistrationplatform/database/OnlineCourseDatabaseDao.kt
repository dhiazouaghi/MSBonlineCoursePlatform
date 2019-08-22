package android.example.msbonlineregistrationplatform.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface OnlineCourseDatabaseDao {
    @Insert
    fun insert(sp: StudentProfile)


    @Update
    fun update(sp: StudentProfile )

    @Query("SELECT * from students_data WHERE sId = :key")
    fun get(key: Long): StudentProfile?


    @Query("DELETE FROM students_data")
    fun clear()


    @Query("SELECT * FROM students_data ORDER BY sId DESC")
    fun getAllStudents(): LiveData<List<StudentProfile>>


    @Query("SELECT * FROM students_data ORDER BY sId DESC LIMIT 1")
    fun gettheStudent(): StudentProfile?


    @Query("SELECT * from students_data WHERE sId = :key")
    fun getstudentWithId(key: Long): LiveData<StudentProfile>
}



