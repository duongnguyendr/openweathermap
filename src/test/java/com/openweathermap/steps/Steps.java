package com.openweathermap.steps;

import org.testng.Assert;

import com.openweathermap.apiServices.ApiServices;
import com.openweathermap.requests.SearchRequest;
import com.openweathermap.response.ErrorResponse;
import com.openweathermap.response.WeatherResponse;
import com.openweathermap.utils.Constant;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class Steps {

	private Response response;
	private ApiServices apiService = new ApiServices(Constant.BASE_URL);

	@Given("I want to search weather in {}")
	public void iWannaSearchWeather(String cityName) {
		SearchRequest searchRequest = new SearchRequest(cityName, Constant.API_KEY);
		response = apiService.getWeatherInCity(searchRequest);
	}
	
	@Given("I search weather in {} with invalid app id")
	public void iWannaSearchWithInvalidAppId(String cityName) {
		SearchRequest searchRequest = new SearchRequest(cityName, "invalid-key");
		response = apiService.getWeatherInCity(searchRequest);
	}

	@Then("I should get the status code is {int}")
	public void iShouldSeeTheStatusCodeAs(int statusCode) {
		Assert.assertEquals(statusCode, response.getStatusCode());
	}

	@Then("I want to print out the weather status")
	public void iWannaPrintOutTheWeatherStatus() {
		WeatherResponse weatherResponse = response.getBody().as(WeatherResponse.class);

		Hooks.scenario.log("City name: " + weatherResponse.name.toString());
		Hooks.scenario.log("Country code: " + weatherResponse.sys.country);

		Hooks.scenario.log("Temperature: " + weatherResponse.main.getTemperatureAsC());
		Hooks.scenario.log("Min temperature: " + weatherResponse.main.getMinTempAsC());
		Hooks.scenario.log("Max temperature: " + weatherResponse.main.getMaxTempAsC());

		Hooks.scenario.log("Wind speed: " + weatherResponse.wind.speed);
		Hooks.scenario.log("Cloud: " + weatherResponse.clouds.all);
		Hooks.scenario.log("Weather status: " + weatherResponse.weather.get(0).description);
	}

	@And("I should get the response relevant: {}")
	public void iShouldGetTheResponseRelevant(String cityName) {
		WeatherResponse weatherResponse = response.getBody().as(WeatherResponse.class);
		String responseName = weatherResponse.name.replace(" ", "");
		String[] cityNames = cityName.split(",");
		String baseName = cityNames[0].replace(" ", "");
		if (!responseName.toLowerCase().contains(baseName.toLowerCase())) {
			Assert.fail("The city name not correct, expected: " + cityName + ", but found: " + responseName);
		}
		if (cityNames.length > 1) {
			Assert.assertEquals(cityNames[cityNames.length - 1].trim().toLowerCase(),
					weatherResponse.sys.country.toLowerCase());
		}
	}

	@And("I should get the message with: {}")
	public void iShouldGetTheMessage(String message) {
		ErrorResponse error = response.getBody().as(ErrorResponse.class);
		Assert.assertEquals(message, error.message);
	}
}
