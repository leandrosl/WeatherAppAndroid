package br.com.lsdl.weatherapp

import android.app.Application
import br.com.lsdl.weatherapp.di.WeatherAppContainer

class WeatherApplication : Application() {
    val injectionContainer: WeatherAppContainer = WeatherAppContainer()
}