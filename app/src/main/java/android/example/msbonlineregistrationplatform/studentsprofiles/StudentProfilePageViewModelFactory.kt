package android.example.msbonlineregistrationplatform.studentsprofiles

import android.app.Application
import android.example.msbonlineregistrationplatform.database.OnlineCourseDatabaseDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StudentProfilePageViewModelFactory (
    private val application: Application,
    private val dataSource: OnlineCourseDatabaseDao) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(StudentProfilePageViewModel::class.java)) {
                return StudentProfilePageViewModel(application, dataSource) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}