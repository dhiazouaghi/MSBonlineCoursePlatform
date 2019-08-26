package android.example.msbonlineregistrationplatform.students


import android.example.msbonlineregistrationplatform.R
import android.example.msbonlineregistrationplatform.database.OnlineCourseDatabase

import android.example.msbonlineregistrationplatform.databinding.StudentLoginBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.student_login.*

class StudentLogin : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(this.activity).application

        val dataSource = OnlineCourseDatabase.getInstance(application).OnlineCourseDatabaseDao()

        // Get a reference to the binding object and inflate the fragment views.
        val binding: StudentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.student_login, container, false
        )

        val viewModelFactory = StudentLoginViewModelFactory(application, dataSource)

        val viewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(StudentLoginViewModel::class.java)


        binding.studentloginviewmodel = viewModel
        binding.setLifecycleOwner(this)
        viewModel.eventlogin.observe(this, Observer { Onlogin ->
            if (Onlogin) {
        Toast.makeText(context,"Login Success", Toast.LENGTH_SHORT).show()}
            else {
                Toast.makeText(context,"email or password is incorrect", Toast.LENGTH_SHORT).show()}
        })

       binding.loginButton.setOnClickListener {
            // your code to perform when the user clicks on the button
            //  Toast.makeText(this, "You clicked me.", Toast.LENGTH_SHORT).show()
           viewModel.onlogin(this)
        }
        return binding.root


    }
}