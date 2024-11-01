package br.com.lsdl.weatherapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lsdl.weatherapp.models.City

class CityViewModel : ViewModel() {
    private val _cities = MutableLiveData<List<City>>(
        mutableListOf(
            City("Belo Horizonte", "Minas Gerais", "Brazil"),
            City("Rio de Janeiro", "Rio de Janeiro", "Brazil"),
            City("São Paulo", "São Paulo", "Brazil")
        )
    )
    val cities: LiveData<List<City>> get() = _cities

    private val _selectedCity = MutableLiveData<City?>()
    val selectedCity: LiveData<City?> = _selectedCity

    fun selectCity(city: City) {
        _selectedCity.value = city
    }
}