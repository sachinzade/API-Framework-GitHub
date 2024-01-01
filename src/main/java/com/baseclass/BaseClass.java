package com.baseclass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	// Get Method for retrieving Data
	public static Response getRequest(String url, String bearerToken) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.get(url);
		return response;
	}

	// Post Method for creating data
	public static Response postRequest(String url, String requestBody, String bearerToken) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestBody);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.post(url);
		return response;
	}

	// Post Method for creating data without body
	public static Response postRequest(String url, String bearerToken) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.post(url);
		return response;
	}

	// Put Method for update data by giving body
	public static Response putRequest(String url, String bearerToken, String body) {
		RequestSpecification requestSpecification = RestAssured.given().body(body);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.put(url);
		return response;
	}

	// Patch Method for update data partially
	public static Response patchRequest(String url, String bearerToken, String body) {
		RequestSpecification requestSpecification = RestAssured.given().body(body);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.patch(url);
		return response;
	}

	// Delete Method for deleting data
	public static Response deleteRequest(String url, String bearerToken) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer " + bearerToken);
		Response response = requestSpecification.delete(url);
		return response;
	}
}
