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
    val e1: ObservableField<String> = ObservableField()
    val p1: ObservableField<String> = ObservableField()

    val students = database.getAllStudents()


  private val _eventlogin = MutableLiveData<Boolean>()
  val eventlogin: LiveData<Boolean>
        get() = _eventlogin

    init {
        Log.i("StudentLoginViewModel", "hey")
    }

    //fun userPresent( mEmail: String, mPassword: String): Boolean {
        //var ex = false



        //cursor.observeForever( Observer<StudentProfile> { student ->

          /*  if (arrayOf(student).size>0) {
                ex = true
            } else {

                ex = false


            }*/



       /* cursor.observe(lifeYcle,
            Observer<StudentProfile> { student ->

                if (student != null) {
                    ex = true
                } else {

                    ex = false


                }
            })
        return ex*/

        //return ex
   // }


    fun onlogin() : Boolean {
        val isRx : Boolean
        val student :StudentProfile  = database.getstudentWithid(e1.get().toString(), p1.get().toString())
      if(student != null){

          isRx = true
          _eventlogin.value=true
      }
        else {

          isRx =false
          _eventlogin.value = false
      }
        return isRx


    }
    fun oncomplete() {
        _eventlogin.value =false
    }
}