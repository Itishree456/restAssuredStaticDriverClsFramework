package testClassPack;

import org.testng.Assert;
import commonFunctionsPack.API_Common_Function;
import io.restassured.path.json.JsonPath;
import requestRepositoryPack.Post_req_repository;

public class Post_TC_1 {

	public static void execute() {

		int statusCode = API_Common_Function.Response_statusCode(Post_req_repository.Base_URI(),
				Post_req_repository.Post_Resource(), Post_req_repository.Post_TC1());
		String responseBody = API_Common_Function.Response_body(Post_req_repository.Base_URI(),
				Post_req_repository.Post_Resource(), Post_req_repository.Post_TC1());

		// Step 3: Parse the response body
		JsonPath jsp = new JsonPath(responseBody);
		String res_name = jsp.getString("name");
		String res_job = jsp.getString("job");
		String res_id = jsp.getString("id");
		String res_createdAt = jsp.getString("createdAt");

		// Step 4: Validate the response body parameters
		Assert.assertEquals(statusCode, 201);
		Assert.assertEquals(res_name, "morpheus");
		Assert.assertEquals(res_job, "leader");

		// Validate "id" and "createdAt" using Assert
		Assert.assertNotNull(res_id);
		Assert.assertNotNull(res_createdAt);

		// Validate "createdAt" using slice method for date
		String expectedDate = new java.util.Date().toInstant().toString().substring(0, 10);
		String actualDate = res_createdAt.substring(0, 10);
		Assert.assertEquals(actualDate, expectedDate);

		System.out.println("Status code is: " + statusCode + " Created");
		System.out.println(responseBody);

	}

}