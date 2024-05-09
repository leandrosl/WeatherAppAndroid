package br.com.lsdl.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.com.lsdl.weatherapp.fragments.ShowTemperatureFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val temperatureFragment = ShowTemperatureFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_activity_fragment_view, temperatureFragment)
            .commit()

        //Fazer o botao da tela inicial abrir a tela de pesquisa
        /*findViewById<FloatingActionButton>(R.id.searchButton).setOnClickListener {
            startActivity(Intent(applicationContext, ListCitiesActivity::class.java))
        }*/
    }
}