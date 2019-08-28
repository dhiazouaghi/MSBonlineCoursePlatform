package android.example.msbonlineregistrationplatform.studentsprofiles

import android.app.Application
import android.example.msbonlineregistrationplatform.database.OnlineCourseDatabaseDao
import androidx.lifecycle.ViewModel

class StudentProfilePageViewModel( application: Application,
    val database: OnlineCourseDatabaseDao
    ) : ViewModel() {

    }
