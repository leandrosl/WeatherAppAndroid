package br.com.lsdl.weatherapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.lsdl.weatherapp.models.City
import br.com.lsdl.weatherapp.repositories.CityRepository
import kotlinx.coroutines.runBlocking

class CityViewModel(private val repository: CityRepository) : ViewModel() {
    private val _cities = MutableLiveData <List<City>>()
    val cities: LiveData<List<City>> = _cities

    private val _selectedCity = MutableLiveData<City?>()
    val selectedCity: LiveData<City?> = _selectedCity

    init {
        _cities.value = repository.getCities()
    }

    fun selectCity(city: City) {
        _selectedCity.value = city
    }

    fun filterCitiesByName(name: String) {
        runBlocking {
           _cities.value = repository.getCitiesByName(name)
        }
    }
}