package net.pubnative.hybidstandalonedemo

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import net.pubnative.hybidstandalonedemo.databinding.ActivityMainBinding
import net.pubnative.lite.sdk.HyBid

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val hybidAppToken = "dde3c298b47648459f8ada4a982fa92d"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_banner, R.id.navigation_interstitial, R.id.navigation_rewarded, R.id.navigation_native))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        HyBid.initialize(hybidAppToken, application)
    }
}