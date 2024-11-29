package br.com.lsdl.weatherapp.repositories

import androidx.lifecycle.MutableLiveData
import br.com.lsdl.weatherapp.models.City

class CityRepositoryImpl : CityRepository {
    override val cities = MutableLiveData(
        listOf(
            City("Belo Horizonte", "Minas Gerais", "Brazil"),
            City("Rio de Janeiro", "Rio de Janeiro", "Brazil"),
            City("São Paulo", "São Paulo", "Brazil")
        )
    )

    override suspend fun getCitiesByName(name: String) {

    }
}