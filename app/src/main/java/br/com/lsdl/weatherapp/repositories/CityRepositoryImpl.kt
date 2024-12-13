package br.com.lsdl.weatherapp.repositories

import br.com.lsdl.weatherapp.models.City
import kotlinx.coroutines.delay

class CityRepositoryImpl : CityRepository {
    private val cities = listOf(
        City("Belo Horizonte", "Minas Gerais", "Brazil"),
        City("Rio de Janeiro", "Rio de Janeiro", "Brazil"),
        City("São Paulo", "São Paulo", "Brazil")
    )

    override fun getCities(): List<City> = cities

    override suspend fun getCitiesByName(name: String): List<City> {
        delay(2000L)
        return cities.filter { city -> city.name.contains(name) }.toList()
    }
}