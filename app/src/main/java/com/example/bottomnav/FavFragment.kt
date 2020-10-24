package com.example.bottomnav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_fav.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FavFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FavFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    var myList  = arrayListOf<String>("Bob", "Nancy", "Marry","Efay", "Melbourne", "Vienna", "Vancouver",
        "Toronto", "Calgary", "Adelaide", "Perth", "Auckland", "Helsinki", "Hamburg", "Munich", "New York",
        "Sydney", "Paris", "Cape Town", "Barcelona", "London", "Bangkok")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_fav, container, false)

        // set the list view
        val favListView = view.findViewById<ListView>(R.id.favListView)
        var arrayAdapter = ArrayAdapter(activity!!.applicationContext, android.R.layout.simple_list_item_1, myList)

        favListView.adapter = arrayAdapter

        //set up the click listern
        favListView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                //assign the value
                var itemValue = favListView.getItemAtPosition(position) as String

                //get the value for the next page
                var actionIntent =
                    Intent(activity, SecondActivity::class.java)
                actionIntent.putExtra("listValue", "position is $position  \nvalue is $itemValue")
                startActivity(actionIntent)
            }

        }



            return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FavFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FavFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}