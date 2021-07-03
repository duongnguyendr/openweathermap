package com.openweathermap.apiServices;

import com.openweathermap.requests.SearchRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiServices {
	private final RequestSpecification request;
	
	public ApiServices(String baseUrl) {
		RestAssured.baseURI = baseUrl;
		request = RestAssured.given();
		request.header("Content-Type", "application/json").header("Accept", "application/json");
	}
	
	public Response getWeatherInCity(SearchRequest searchRequest) {
		Response response = request.queryParams(searchRequest.queryParameter()).get("/weather");
		return response;
	}
}
