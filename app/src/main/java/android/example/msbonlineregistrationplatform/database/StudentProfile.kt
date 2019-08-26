package android.example.msbonlineregistrationplatform.database

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students_data")
data class StudentProfile(
    @PrimaryKey(autoGenerate = true)
    var sId: Long = 0L,

    @ColumnInfo(name = "email_address")
    val emails: String = "",

    @ColumnInfo(name = "password")
    var password: String = "" ,

    @ColumnInfo(name = "student_name")
    var student_name: String = "",

    @ColumnInfo(name = "department")
    var department: String = "",

    @ColumnInfo(name = "student_photo")
    var student_photo: String="",

    @ColumnInfo(name = "current_gpa")
    var cgpa: Int = 0

)

