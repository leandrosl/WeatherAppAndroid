package br.com.lsdl.weatherapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.lsdl.weatherapp.R
import br.com.lsdl.weatherapp.models.City
import br.com.lsdl.weatherapp.viewadapters.ListCitiesAdapter
import br.com.lsdl.weatherapp.viewmodels.CityViewModel

class SearchCityFragment : Fragment() {
    private lateinit var cityViewModel: CityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as AppCompatActivity

        val fragmentToolbar = view.findViewById<Toolbar>(R.id.toolbar)

        activity.setSupportActionBar(fragmentToolbar)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.setDisplayShowTitleEnabled(false)

        cityViewModel = ViewModelProvider(activity)[CityViewModel::class.java]

        initListCitiesView(view)
    }

    private fun initListCitiesView(view: View) {
        val citiesViewAdapter = ListCitiesAdapter()

        val citiesRecyclerView: RecyclerView = view.findViewById(R.id.cities_list_recycler_view)
        citiesRecyclerView.adapter = citiesViewAdapter
        citiesRecyclerView.layoutManager = LinearLayoutManager(context)

        cityViewModel.cities.observe(viewLifecycleOwner) { updatedList ->
            citiesViewAdapter.updateList(updatedList)
        }

        citiesViewAdapter.setOnItemClickListener(object : ListCitiesAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, city: City) {
                cityViewModel.selectCity(city)
                parentFragmentManager.popBackStack()
            }
        })
    }
}