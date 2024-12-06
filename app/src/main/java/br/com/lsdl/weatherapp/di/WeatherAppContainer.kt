package br.com.lsdl.weatherapp.di

import br.com.lsdl.weatherapp.repositories.CityRepository
import br.com.lsdl.weatherapp.repositories.CityRepositoryImpl
import br.com.lsdl.weatherapp.viewmodels.CityViewModel

class WeatherAppContainer {
    private val cityRepository: CityRepository = CityRepositoryImpl()

    val cityViewModel = CityViewModel(cityRepository)
}