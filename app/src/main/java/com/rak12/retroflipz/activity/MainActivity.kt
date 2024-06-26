package com.rak12.retroflipz.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rak12.retroflipz.R
import com.rak12.retroflipz.adapter.GamesAdapter
import com.rak12.retroflipz.model.Games
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var sp: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp=getSharedPreferences(
            R.string.fileSharedPreference.toString(),
            MODE_PRIVATE)
        if(sp.getBoolean("passwordentered",true)){
            val intent=Intent(this,PasswordActivity::class.java)
            startActivity(intent)
        }
        navController=findNavController(R.id.navHostFragment)
        val appBarConfiguration= AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.favFragment,
                R.id.parentalControlFragment
            ))

        bottomnav.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }



}