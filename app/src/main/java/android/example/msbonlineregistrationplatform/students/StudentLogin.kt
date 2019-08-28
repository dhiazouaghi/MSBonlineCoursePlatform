package android.example.msbonlineregistrationplatform.students


import android.content.Intent
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
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
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

        //binding.loginButton.setOnClickListener {
            // your code to perform when the user clicks on the button
            //  Toast.makeText(this, "You clicked me.", Toast.LENGTH_SHORT).show()
            viewModel.eventlogin.observe(this, Observer { hasfinished ->

            if (hasfinished) {
                Navigation.createNavigateOnClickListener(R.id.action_studentLogin_to_studentProfilePage)
                //viewModel.oncomplete()
            }

        else {
                Toast.makeText(context, "email or password is incorrect", Toast.LENGTH_SHORT).show()
            }

        })


        /* viewModel.eventlogin.observe(this, Observer { Onlogin ->
             if (Onlogin) {
                 // findNavController(view).navigate(R.id
             }
             else {
                 Toast.makeText(context,"email or password is incorrect", Toast.LENGTH_SHORT).show()}
         })*/


    return binding.root


}
}