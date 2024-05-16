package br.com.lsdl.weatherapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.lsdl.weatherapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ShowTemperatureFragment : Fragment() {
    private lateinit var searchButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_temperature, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchButton = view.findViewById(R.id.searchButton)

        searchButton.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.main_activity_fragment_view, SearchCityFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}