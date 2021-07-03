package com.openweathermap.model;

import com.openweathermap.utils.Utils;

public class WeatherInformation {
	public double temp;
	public double feels_like;
	public double temp_min;
	public double temp_max;
	public int pressure;
	public int humidity;
	public int sea_level;
	public int grnd_level;
	
	public double getTemperatureAsK() {
		return temp;
	}
	
	public double getTemperatureAsC() {
		return Utils.convertKelvinToCelsius(temp);
	}
	
	public double getTemperatureAsF() {
		return Utils.convertKelvinToFahrenheit(temp);
	}
	
	public double getFeelsLikeAsK() {
		return feels_like;
	}
	
	public double getFeelsLikeAsC() {
		return Utils.convertKelvinToCelsius(feels_like);
	}
	
	public double getFeelsLikeAsF() {
		return Utils.convertKelvinToFahrenheit(feels_like);
	}
	
	public double getMinTempAsK() {
		return temp_min;
	}
	
	public double getMinTempAsC() {
		return Utils.convertKelvinToCelsius(temp_min);
	}
	
	public double getMinTempAsF() {
		return Utils.convertKelvinToFahrenheit(temp_min);
	}
	
	public double getMaxTempAsK() {
		return temp_max;
	}
	
	public double getMaxTempAsC() {
		return Utils.convertKelvinToCelsius(temp_max);
	}
	
	public double getMaxTempAsF() {
		return Utils.convertKelvinToFahrenheit(temp_max);
	}
}
