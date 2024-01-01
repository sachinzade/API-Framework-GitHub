package com.testclasses;

import java.io.IOException;
import java.util.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.baseclass.BaseClass;
import com.utility.Authentication;
import com.utility.CommonResponse;
import com.utility.CreateUrl;
import com.utility.PayloadConvert;

import Dtos.GithubDtos;
import Helper.GitHiubHelper;
import endPoints.GitHubRepoEndPoint;
import io.restassured.response.Response;

public class GitHubRepoAutomation {

	public static String bearerToken = Authentication.getBearerToken();
	public static Response response;
	public String updatedName;
	GitHubRepoEndPoint ghEndpoint = new GitHubRepoEndPoint();
	GitHiubHelper ghHelper = new GitHiubHelper();
	GithubDtos ghDtos = new GithubDtos();

	@Test(priority = 1)
	public void createRepoTest() throws IOException {
		String requestPayload = PayloadConvert.generateData("CreateRepos.json");
		// System.out.println(dataProvider.get("name"));
		// String pay = ghHelper.preparePayloadForCreatingRepo(dataProvider.get("name"),
		// dataProvider.get("description"));

		response = BaseClass.postRequest(ghEndpoint.getCreateRepoEendpoint(), requestPayload, bearerToken);
		String responseBody = response.getBody().asString();
		Assert.assertEquals(CommonResponse.getResponsevalue(requestPayload, "name"),
				CommonResponse.getResponsevalue(responseBody, "name"));
		Assert.assertEquals(CommonResponse.getstatuscode(response), 201);
	}

	@Test(priority = 2)
	public void getRepos() throws IOException {
		String requestPayload = PayloadConvert.generateData("GetRepo.json");
		response = BaseClass.getRequest(ghEndpoint.getGetReposEndPoint(), bearerToken);
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		// String dName = response.jsonPath().get("name");

		Assert.assertTrue(responseBody.contains(CommonResponse.getResponsevalue(requestPayload, "name")));
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 3)
	public void updateAndDeleteRequest() throws IOException {
		String upName = ghDtos.getName();
		String description = ghDtos.getDescription();
		String psyload1 = ghHelper.preparePayloadForUpdateRepo(upName, description);
		// String requestPayload = PayloadConvert.generateData("Update.json");
		// response = BaseClass.patchRequest(ghEndpoint.getUpdateRepoendPoint(),
		// bearerToken, requestPayload);
		response = BaseClass.patchRequest(ghEndpoint.getUpdateRepoendPoint(), bearerToken, psyload1);
		String responseBody = response.body().asString();
		updatedName = response.jsonPath().get("name");
//		Assert.assertEquals(CommonResponse.getResponsevalue(requestPayload, "name"),
//				CommonResponse.getResponsevalue(responseBody, "name"));
		Assert.assertEquals(CommonResponse.getResponsevalue(psyload1, "name"),
				CommonResponse.getResponsevalue(responseBody, "name"));
		Assert.assertEquals(CommonResponse.getstatuscode(response), 200);

		response = BaseClass.deleteRequest(ghEndpoint.getDeleteRepoEndPoint(updatedName), bearerToken);
		Assert.assertEquals(CommonResponse.getstatuscode(response), 204);
	}

//	@Test(priority = 4)
//	public void deleteRequest() {
//		response = BaseClass.deleteRequest(ghEndpoint.getDeleteRepoEndPoint(updatedName), bearerToken);
//
//		Assert.assertEquals(CommonResponse.getstatuscode(response), 204);
//		
//	}

//	@Test(priority = 5)
//	public void getListOfForks() {
//		response = BaseClass.getRequest(ghEndpoint.getListofForksRepoEndPoint(), bearerToken);
//		System.out.println(response.getBody().asString());
//		Assert.assertEquals(CommonResponse.getstatuscode(response), 200);
//
//	}

}