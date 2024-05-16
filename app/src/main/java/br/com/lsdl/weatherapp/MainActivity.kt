package br.com.lsdl.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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