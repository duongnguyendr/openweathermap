package com.openweathermap.response;

import java.util.List;

import com.openweathermap.model.Clouds;
import com.openweathermap.model.Coordinate;
import com.openweathermap.model.Rain;
import com.openweathermap.model.Snow;
import com.openweathermap.model.Sys;
import com.openweathermap.model.Weather;
import com.openweathermap.model.WeatherInformation;
import com.openweathermap.model.Wind;

public class WeatherResponse {
	public Coordinate coord;
	public List<Weather> weather;
	public String base;
	public WeatherInformation main;
	public long visibility;
	public Wind wind;
	public Clouds clouds;
	public Rain rain;
	public Snow snow;
	public long dt;
	public Sys sys;
	public int timezone;
	public int id;
	public String name;
	public int cod;
}
