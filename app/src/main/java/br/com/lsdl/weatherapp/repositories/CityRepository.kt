package br.com.lsdl.weatherapp.repositories

import br.com.lsdl.weatherapp.models.City

interface CityRepository {
    suspend fun getCitiesByName(name: String): List<City>
    fun getCities(): List<City>
}