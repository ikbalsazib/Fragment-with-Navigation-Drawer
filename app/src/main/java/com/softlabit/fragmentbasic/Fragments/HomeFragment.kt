package com.softlabit.fragmentbasic.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.softlabit.fragmentbasic.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment:Fragment() {
    lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mView = inflater.inflate(R.layout.fragment_home, container, false)

        // Btn Click...
        mView.test_btn.setOnClickListener {
            Toast.makeText(activity, "Test Click", Toast.LENGTH_SHORT).show()
        }
        return mView
    }
}