package br.com.lsdl.weatherapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lsdl.weatherapp.models.City
import br.com.lsdl.weatherapp.repositories.CityRepository

class CityViewModel(private val repository: CityRepository) : ViewModel() {
    val cities: LiveData<List<City>> get() = repository.cities

    private val _selectedCity = MutableLiveData<City?>()
    val selectedCity: LiveData<City?> = _selectedCity

    fun selectCity(city: City) {
        _selectedCity.value = city
    }
}