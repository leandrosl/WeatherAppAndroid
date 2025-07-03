package br.com.lsdl.weatherapp.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.lsdl.weatherapp.R
import br.com.lsdl.weatherapp.fragments.ShowTemperatureFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_activity_fragment_view, ShowTemperatureFragment())
            .commit()
    }
}