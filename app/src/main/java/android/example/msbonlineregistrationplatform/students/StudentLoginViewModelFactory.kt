package android.example.msbonlineregistrationplatform.students

import android.app.Application
import android.example.msbonlineregistrationplatform.database.OnlineCourseDatabaseDao
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StudentLoginViewModelFactory (

    private val application: Application,
        private val dataSource: OnlineCourseDatabaseDao) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(StudentLoginViewModel::class.java)) {
                return StudentLoginViewModel(application, dataSource) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
