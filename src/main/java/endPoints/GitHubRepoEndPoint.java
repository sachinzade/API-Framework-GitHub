package endPoints;

import com.utility.CreateUrl;

public class GitHubRepoEndPoint {
	private final String createRepoEendpoint = CreateUrl.getBaseUri("/user/repos");
	private final String getReposEndPoint = CreateUrl.getBaseUri("/users/sachinzade/repos");
	private final String updateRepoendPoint = CreateUrl.getBaseUri("/repos/sachinzade/API-Framework");
	private final String deleteRepoEndPoint = CreateUrl.getBaseUri("/repos/sachinzade/");
	private final String listofForksEndPoint = CreateUrl.getBaseUri("/repos/sachinzade/Xyz/forks");
	
	public String getCreateRepoEendpoint() {
		return createRepoEendpoint;
	}
	public String getGetReposEndPoint() {
		return getReposEndPoint;
	}
	public String getUpdateRepoendPoint() {
		return updateRepoendPoint;
	}
	public String getDeleteRepoEndPoint(String upName) {
		return deleteRepoEndPoint+upName;
	}
//	public String getDeleteRepoEndPoint() {
//		return deleteRepoEndPoint;
//	}
	public String getListofForksRepoEndPoint() {
		return listofForksEndPoint;
	}
	
	



}
