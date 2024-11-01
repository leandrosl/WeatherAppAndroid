package br.com.lsdl.weatherapp.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.lsdl.weatherapp.R
import br.com.lsdl.weatherapp.viewmodels.CityViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShowTemperatureFragment : Fragment() {
    private lateinit var searchButton: FloatingActionButton

    private lateinit var cityViewModel: CityViewModel

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

        searchButton = view.findViewById(R.id.searchButton)

        cityViewModel = ViewModelProvider(activity)[CityViewModel::class.java]

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
                Log.d("SELECTED_CITY", selectedCity.name)
            }
        }
    }
}