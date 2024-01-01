package com.utility;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadConvert {

	public static String generateData(String fileName) throws IOException {

		String filePath = "./src/main/java/com/resources/" + fileName;

		return new String(Files.readAllBytes(Paths.get(filePath)));

	}

	private final ObjectMapper objectMapper = new ObjectMapper();

	public Object[][] convertJsonToData(String filePath) {
		File inputFile = new File(filePath);
		LinkedHashMap<String, Object> jsonObject = null;
		try {
			jsonObject = objectMapper.readValue(inputFile, new TypeReference<LinkedHashMap<String, Object>>() {
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		// objectMapper.convert
		Map<Object, String> dataJson = (Map<Object, String>) jsonObject.clone();
		Object[][] object = new Object[1][1];
		object[0][0] = dataJson;

		return object;
	}

	@DataProvider(name = "dp", parallel = true)
	public Object[][] dataProviderForTest(Method methodName) {
		// return convertJsonToData(System.getProperty("user.dir") +
		// "./src/main/java/com/resources" +
		// methodName.getDeclaringClass().getSimpleName() +".json");
		return convertJsonToData(
				System.getProperty("C:/Users/USER/eclipse-workspace/RestAssured_GitHubApi/src/main/java/com/resources/")
						+ methodName.getDeclaringClass().getSimpleName() + ".json");
	}
}
