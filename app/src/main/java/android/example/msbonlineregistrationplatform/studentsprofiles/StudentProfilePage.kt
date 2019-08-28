package android.example.msbonlineregistrationplatform.studentsprofiles

import android.example.msbonlineregistrationplatform.R
import android.example.msbonlineregistrationplatform.databinding.StudentProfilePageBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment

class StudentProfilePage : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: StudentProfilePageBinding = DataBindingUtil.inflate(
            inflater, R.layout.student_profile_page, container, false
        )
        return binding.root
    }}