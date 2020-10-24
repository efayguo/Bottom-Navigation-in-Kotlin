package com.example.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    // create obejcts for fragments
    lateinit var homeFragment: HomeFragment
    lateinit var favFragment: FavFragment
    lateinit var messageFragment: MessageFragment
    lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set home page as the main page
        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.layoutFrame, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                // where you tell which fragment is which
                R.id.home ->{
                    homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layoutFrame, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.favorite ->{
                    favFragment = FavFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layoutFrame, favFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.message ->{
                    messageFragment = MessageFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layoutFrame, messageFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
                R.id.profile ->{
                    profileFragment = ProfileFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.layoutFrame, profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }
            }

            true
        }
    }
}