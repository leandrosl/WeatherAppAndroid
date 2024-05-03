package br.com.lsdl.weatherapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.lsdl.weatherapp.models.City
import br.com.lsdl.weatherapp.viewadapters.ListCitiesAdapter

class ListCitiesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cities)
        setSupportActionBar(findViewById(R.id.toolbar))

        initListCitiesView()
    }

    private fun initListCitiesView() {
        val listCities = listOf(
            City("Belo Horizonte", "Minas Gerais", "Brazil"),
            City("Rio de Janeiro", "Rio de Janeiro", "Brazil"),
            City("São Paulo", "São Paulo", "Brazil")
        )
        val citiesViewAdapter = ListCitiesAdapter(listCities)

        val citiesRecyclerView: RecyclerView = findViewById(R.id.cities_list_recycler_view)
        citiesRecyclerView.adapter = citiesViewAdapter
        citiesRecyclerView.layoutManager = LinearLayoutManager(applicationContext)

        citiesViewAdapter.setOnItemClickListener(object : ListCitiesAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, city: City) {
                Toast.makeText(applicationContext, city.name, Toast.LENGTH_SHORT).show()
            }
        })
    }
}