package android.example.msbonlineregistrationplatform.students

import android.app.Application
import android.example.msbonlineregistrationplatform.database.OnlineCourseDatabaseDao
import android.example.msbonlineregistrationplatform.database.StudentProfile
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentLoginViewModel(
    application: Application,
    val database: OnlineCourseDatabaseDao
) : ViewModel() {
    private var student = MutableLiveData<StudentProfile?>()
    val students = database.getAllStudents()
init{
    Log.i("StudentLoginViewModel","hey")
}

}
