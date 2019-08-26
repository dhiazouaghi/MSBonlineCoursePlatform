package android.example.msbonlineregistrationplatform.students

import android.app.Application

import android.example.msbonlineregistrationplatform.database.OnlineCourseDatabaseDao
import android.example.msbonlineregistrationplatform.database.StudentProfile
import android.util.Log

import androidx.databinding.ObservableField
import androidx.lifecycle.*

class StudentLoginViewModel(
    application: Application,
    val database: OnlineCourseDatabaseDao
) : ViewModel() {
    private var student = MutableLiveData<StudentProfile?>()
    val students = database.getAllStudents()
    val e1: ObservableField<String> = ObservableField()
    val p1: ObservableField<String> = ObservableField()
    private val _eventlogin = MutableLiveData<Boolean>()
    val eventlogin: LiveData<Boolean>
        get() = _eventlogin

    init {
        Log.i("StudentLoginViewModel", "hey")
    }

    fun userPresent(lifeYcle: LifecycleOwner, mEmail: String, mPassword: String): Boolean {
        var ex = false

        val cursor = database.getstudentWithid(mEmail, mPassword)
        /*  if (cursor.value!= null) {


              return true
          } else {
              return false
          }*/

        cursor.observe(lifeYcle,
            Observer<StudentProfile> { student ->

                if (student != null) {
                    ex = true
                } else {

                    false


                }
            })
        return ex
    }

    fun onlogin(lifeCycle: LifecycleOwner) {
        if (userPresent(lifeCycle, e1.get().toString(), p1.get().toString()) == true) {
            _eventlogin.value = true
        } else {
            _eventlogin.value = false
        }
    }
}