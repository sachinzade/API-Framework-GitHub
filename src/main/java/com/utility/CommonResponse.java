package com.utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonResponse {

	public static JsonPath jsonpath;

	public static String getResponsevalue(String responseBody, String responseObj) {
		jsonpath = new JsonPath(responseBody);
		String obj_value = jsonpath.get(responseObj);
		return obj_value;
	}

	public static int getstatuscode(Response response) {
		int status_code = response.getStatusCode();
		return status_code;
	}

}
