package com.openweathermap.requests;

import java.util.HashMap;
import java.util.Map;

public class SearchRequest {
	private String q;
	private String appid;
	
	public SearchRequest(String q, String appid) {
		this.q = q;
		this.appid = appid;
	}
	
	public Map<String, String> queryParameter(){
		Map<String, String > params = new HashMap<>();
		params.put("q", q);
		params.put("appid", appid);
		return params;
	}
}
