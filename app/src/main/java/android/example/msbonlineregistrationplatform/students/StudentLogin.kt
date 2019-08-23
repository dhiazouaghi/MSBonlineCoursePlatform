package android.example.msbonlineregistrationplatform.students


import android.example.msbonlineregistrationplatform.R
import android.example.msbonlineregistrationplatform.database.OnlineCourseDatabase

import android.example.msbonlineregistrationplatform.databinding.StudentLoginBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import androidx.lifecycle.ViewModelProviders

class StudentLogin : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: StudentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.student_login, container, false
        )
        val application = requireNotNull(this.activity).application

        val dataSource = OnlineCourseDatabase.getInstance(application).OnlineCourseDatabaseDao()

        val viewModelFactory = StudentLoginViewModelFactory(application, dataSource)

        val viewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(StudentLoginViewModel::class.java)


        binding.studentloginviewmodel = viewModel
        //binding.setLifecycleOwner(this)
        return binding.root


    }
}