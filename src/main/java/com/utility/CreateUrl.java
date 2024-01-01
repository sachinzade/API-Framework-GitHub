package com.utility;

public class CreateUrl {

	public final static String baseUri = "https://api.github.com";

	public static String getBaseUri() {
		return baseUri;
	}

	public static String getBaseUri(String resources) {
		return baseUri + resources;
	}

}
