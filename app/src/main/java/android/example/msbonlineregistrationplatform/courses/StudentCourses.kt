package android.example.msbonlineregistrationplatform.courses

import android.example.msbonlineregistrationplatform.R
import android.example.msbonlineregistrationplatform.databinding.StudentCoursesBinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
class StudentCourses: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { val binding: StudentCoursesBinding = DataBindingUtil.inflate(
        inflater, R.layout.student_courses, container, false
    )
        binding.setLifecycleOwner(this)
        return binding.root
}}