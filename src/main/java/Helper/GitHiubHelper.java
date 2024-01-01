package Helper;

import com.google.gson.Gson;

import Dtos.GithubDtos;

public class GitHiubHelper {

	GithubDtos ghDtos = new GithubDtos();
	Gson gson = new Gson();

	public String preparePayloadForCreatingRepo(String name, String description) {
		ghDtos.setName(name);
		ghDtos.setDescription(description);
		return gson.toJson(ghDtos);

	}

	public String preparePayloadForUpdateRepo(String name, String description) {
		ghDtos.setName(name);
		ghDtos.setDescription(description);
		return gson.toJson(ghDtos);

	}

}
