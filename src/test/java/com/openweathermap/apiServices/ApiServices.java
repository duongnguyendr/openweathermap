package com.openweathermap.apiServices;

import com.openweathermap.requests.SearchRequest;
import com.openweathermap.utils.Constant;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiServices {
	
	public static Response getWeatherInCity(SearchRequest searchRequest) {
		RestAssured.baseURI = Constant.BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json").header("Accept", "application/json");
		Response response = request.queryParams(searchRequest.queryParameter()).get("/weather");
		return response;
	}
}
