package com.example.bottomnav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        //set the button on fragment view
        val clickMeButton = view.findViewById<Button>(R.id.clickMeButton)
        clickMeButton.setOnClickListener(this)

        val nextPageButton = view.findViewById<Button>(R.id.nextPageButton)
        nextPageButton.setOnClickListener(this)

        return view
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }


    fun onButtonClick(view: MainActivity) {
        Toast.makeText(activity, "The button is clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {

                R.id.clickMeButton -> {
                    Toast.makeText(activity, "The button is clicked", Toast.LENGTH_SHORT).show()
                }
                R.id.nextPageButton -> {
                    startActivity(Intent(activity, SecondActivity::class.java))
                }
            }
        }

    }
}