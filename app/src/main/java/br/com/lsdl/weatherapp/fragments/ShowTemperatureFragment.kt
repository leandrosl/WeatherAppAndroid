package br.com.lsdl.weatherapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.lsdl.weatherapp.R
import br.com.lsdl.weatherapp.WeatherApplication
import br.com.lsdl.weatherapp.di.WeatherAppContainer
import br.com.lsdl.weatherapp.viewmodels.CityViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShowTemperatureFragment : Fragment() {
    private lateinit var searchButton: FloatingActionButton

    private lateinit var cityViewModel: CityViewModel

    private lateinit var injectionContainer: WeatherAppContainer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_temperature, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = requireActivity() as AppCompatActivity

        injectionContainer = (activity.application as WeatherApplication).injectionContainer

        searchButton = view.findViewById(R.id.searchButton)

        cityViewModel = injectionContainer.cityViewModel

        searchButton.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.main_activity_fragment_view, SearchCityFragment())
                .addToBackStack(null)
                .commit()
        }

        cityViewModel.selectedCity.observe(viewLifecycleOwner) { selectedCity ->
            selectedCity?.let {
                Log.d("SELECTED_CITY", selectedCity.toString())
                view.findViewById<TextView>(R.id.cityName).text = selectedCity.name
                view.findViewById<TextView>(R.id.cityState).text = selectedCity.stateName
                view.findViewById<TextView>(R.id.cityCountry).text = selectedCity.country
            }
        }
    }
}