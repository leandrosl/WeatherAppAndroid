package br.com.lsdl.weatherapp.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.lsdl.weatherapp.R
import br.com.lsdl.weatherapp.WeatherApplication
import br.com.lsdl.weatherapp.di.WeatherAppContainer
import br.com.lsdl.weatherapp.models.City
import br.com.lsdl.weatherapp.viewadapters.ListCitiesAdapter
import br.com.lsdl.weatherapp.viewmodels.CityViewModel

class SearchCityFragment : Fragment() {
    private lateinit var cityViewModel: CityViewModel

    private lateinit var injectionContainer: WeatherAppContainer

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

        injectionContainer = (activity.application as WeatherApplication).injectionContainer

        val fragmentToolbar = view.findViewById<Toolbar>(R.id.toolbar)

        activity.setSupportActionBar(fragmentToolbar)
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        activity.supportActionBar?.setDisplayShowTitleEnabled(false)

        cityViewModel = injectionContainer.cityViewModel

        initListCitiesView(view)
        initSearchBar(view)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_search_city_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_app_settings -> {
                Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show()
                return true
            }
            android.R.id.home -> {
                activity?.supportFragmentManager?.popBackStack()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
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

    private fun initSearchBar(view: View) {
        val toolbarSearchEditText: EditText = view.findViewById(R.id.search_city_edit_text)
        toolbarSearchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                cityViewModel.filterCitiesByName(toolbarSearchEditText.text.toString())
            }
        })
    }
}