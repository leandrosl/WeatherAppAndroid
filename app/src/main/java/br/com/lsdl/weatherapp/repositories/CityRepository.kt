package br.com.lsdl.weatherapp.repositories

import androidx.lifecycle.MutableLiveData
import br.com.lsdl.weatherapp.models.City

interface CityRepository {
    val cities: MutableLiveData<List<City>>
    suspend fun getCitiesByName(name: String)
}